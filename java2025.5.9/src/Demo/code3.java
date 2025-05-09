package Demo;

import java.util.concurrent.*;

public class code3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService executorService = Executors.newCachedThreadPool();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 5; i++) {
            int number = i;
            threadPoolExecutor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread() + "----" + number);
                    Thread.sleep(500);
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        System.out.println(countDownLatch.getCount());
        countDownLatch.await();
        System.out.println("over");
    }
}
