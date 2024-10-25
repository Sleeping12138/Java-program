package Demo1;

import java.util.concurrent.locks.ReentrantLock;

public class demo3 {

    public static int number = 0;

    public static void main(String[] args) throws InterruptedException {


        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    reentrantLock.lock();
                    number++;
                    System.out.println(Thread.currentThread().getName() + "  " + number);
                } finally {
                    reentrantLock.unlock();
                }

            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    reentrantLock.lock();
                    number++;
                    System.out.println(Thread.currentThread().getName() + "  " + number);
                } finally {
                    reentrantLock.unlock();
                }

            }
        });

        thread2.start();
        thread1.start();
        Thread.sleep(1000);
        System.out.println(number);
    }
}
