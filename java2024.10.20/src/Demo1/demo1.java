package Demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class demo1 {
    private static final AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(100);

        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    blockingQueue.put("hello");
                int currentValue = number.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + "  " + currentValue);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "生产者");

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    blockingQueue.take();
                    int currentValue = number.decrementAndGet();
                    System.out.println(Thread.currentThread().getName() + "  " + currentValue);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "消费者");

        thread1.start();
        thread2.start();
    }
}
