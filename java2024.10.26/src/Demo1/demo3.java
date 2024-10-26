package Demo1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo3 {
    public static void main(String[] args) throws InterruptedException {

        // 有十个任务
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int id = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " --- " + id);
                // 每执行完一个任务就减去一
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println("main函数结束...");
    }
}
