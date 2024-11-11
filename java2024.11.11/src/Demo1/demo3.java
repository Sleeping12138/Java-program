package Demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

// 生产者消费者模型
public class demo3 {
    public static final int capacity = 10;
    public static int number = 0;

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(capacity);
        Object locker = new Object();
        Thread producer = new Thread(() -> {
            while (true) {
                synchronized (locker) {
                    try {
                        while (blockingQueue.size() == capacity) {
                            locker.wait();
                        }
                        number++;
                        blockingQueue.put(number);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    locker.notify();
                }
            }
        }, "生产者");

        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (locker) {
                    try {
                        while (blockingQueue.isEmpty()) {
                            locker.wait();
                        }
                        int temp = blockingQueue.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    number--;
                    locker.notify();
                }
            }
        }, "消费者");
        producer.start();
        consumer.start();
    }
}
