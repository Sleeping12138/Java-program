package Demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class demo5 {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue =new LinkedBlockingQueue<>(10);
        Thread producer = new Thread(()->{
            while (true) {
                atomicInteger.incrementAndGet();
                try {
                    System.out.println(Thread.currentThread().getName()+" "+atomicInteger.get());
                    blockingQueue.put(atomicInteger.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(()->{
            while (true) {
                atomicInteger.decrementAndGet();
                try {
                    System.out.println(Thread.currentThread().getName()+" "+atomicInteger.get());
                    blockingQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
