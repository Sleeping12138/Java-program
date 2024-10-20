package Demo1;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class demo3 {
    public static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    int ret = number.incrementAndGet();
                    System.out.println(Thread.currentThread() + "  " + ret);
                }
            }, "Thread-" + i).start();
        }

        Thread.sleep(2000);
        number.set(0);
        System.out.println(number.get());
        System.out.println("over");
    }
}
