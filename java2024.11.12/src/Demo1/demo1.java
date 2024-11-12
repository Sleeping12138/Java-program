package Demo1;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 线程池
public class demo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,
                8,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.submit(()->{
                System.out.println(Thread.currentThread().getName()+" "+"正在工作...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        threadPoolExecutor.shutdown();

        try {
            if(!threadPoolExecutor.awaitTermination(5,TimeUnit.SECONDS)){
                System.out.println("任务未完成..");
            }else{
                System.out.println("任务完成...");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            threadPoolExecutor.shutdownNow();
        }
    }
}
