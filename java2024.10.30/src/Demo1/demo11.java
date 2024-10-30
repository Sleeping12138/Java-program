package Demo1;

import java.util.concurrent.atomic.AtomicInteger;

public class demo11 {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                int number = atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " " + number);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                int number = atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " " + number);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(atomicInteger.get());

    }
}
