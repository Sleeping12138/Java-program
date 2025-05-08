package Demo;

import java.util.concurrent.*;

public class code8 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        Future<String> submit = threadPoolExecutor.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread() + "-------" + i);
            }
            return "任务完成";
        });

        threadPoolExecutor.shutdown();

        if (!threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("结束异常");
            threadPoolExecutor.shutdownNow();
        }else {
            System.out.println("正常结束");
        }

    }
}
