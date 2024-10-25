package Demo1;

import java.util.concurrent.*;

public class demo9 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.submit(() -> {
                int ret = 0;
                for (int j = 1; j <= 100; j++) {
                    ret += j;
                }
                System.out.println(ret);
            });
        }

        threadPoolExecutor.shutdown();

        if(threadPoolExecutor.awaitTermination(10,TimeUnit.SECONDS)){
            System.out.println("正常关闭...");
        }else{
            threadPoolExecutor.shutdownNow();
            System.out.println("异常关闭...");
        }
    }
}
