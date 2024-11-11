package Demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class demo4 {
    public static final int CAPACITY = 10;
    public static int number = 0;

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(CAPACITY);
        Object lock = new Object();  // 用于同步的锁

        Thread producer = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        // 如果队列满了，生产者等待
                        while (blockingQueue.size() == CAPACITY) {
                            lock.wait();
                        }
                        // 模拟生产数据
                        number++;
                        blockingQueue.put(number);
                        System.out.println(Thread.currentThread().getName() + " produced: " + number);
                        lock.notify();  // 唤醒消费者
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }, "生产者");

        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        // 如果队列为空，消费者等待
                        while (blockingQueue.isEmpty()) {
                            lock.wait();
                        }
                        // 模拟消费数据
                        int item = blockingQueue.take();
                        System.out.println(Thread.currentThread().getName() + " consumed: " + item);
                        number--;
                        lock.notify();  // 唤醒生产者
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }, "消费者");

        producer.start();
        consumer.start();
    }
}

