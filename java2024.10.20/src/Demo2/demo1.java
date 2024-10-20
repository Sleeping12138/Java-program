package Demo2;


import java.util.concurrent.atomic.AtomicInteger;

// 线程安全的计数器的使用 - AtomicInteger
public class demo1 {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                int temp = atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + "  " + temp);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                int temp = atomicInteger.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + "  " + temp);
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println(atomicInteger.get());

    }
}
