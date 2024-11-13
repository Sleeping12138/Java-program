package Demo1;

import java.util.concurrent.*;

// countDownLatch
public class demo6 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                6,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 10; i++) {
            int number = i;
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " " + "正在完成任务....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + "任务完成...");
                countDownLatch.countDown();
            });
        }

        threadPoolExecutor.shutdown();
        try {
            if(!threadPoolExecutor.awaitTermination(5,TimeUnit.SECONDS)){
                System.out.println("任务没有全部完成...");
                threadPoolExecutor.shutdownNow();
            }else{
                System.out.println("任务全部完成...");
            }
        } finally {
            threadPoolExecutor.shutdownNow();
        }

        countDownLatch.await();
        System.out.println("overing...");
    }
}
