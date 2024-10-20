package Demo1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class demo5 {
    public static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
//de
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                int temp = number.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + "  " + temp);
            }
        }, "Thread1");
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                int temp = number.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + "  " + temp);
            }
        }, "Thread2");
        thread1.start();
        thread2.start();

        Thread.sleep(1000);
        System.out.println(number.get());
    }
}
