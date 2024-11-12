package Demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService service = Executors.newSingleThreadExecutor();
//        ExecutorService service1 = Executors.newScheduledThreadPool();
        for (int i = 0; i < 10000; i++) {
            int number = i;
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName()+" "+number);
            });
        }

        executorService.shutdown();

    }
}
