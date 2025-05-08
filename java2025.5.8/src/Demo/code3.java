package Demo;

import java.util.concurrent.atomic.AtomicInteger;

public class code3 {

//    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static int n = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                n++;
                System.out.println(Thread.currentThread().getName() + "------" + n);
            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                n++;
                System.out.println(Thread.currentThread().getName() + "------" + n);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println("over");
    }
}
