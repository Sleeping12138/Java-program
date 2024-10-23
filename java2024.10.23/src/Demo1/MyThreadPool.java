package Demo1;
// 线程池的自我实现

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    // 阻塞队列用来存储submit过来的任务
    private BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(1000);


    // 线程池中线程的创建
    public MyThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(()->{
                while (true) {
                    try {
                        Runnable ret = blockingQueue.take();
                        ret.run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();
        }
    }

    // submit方法呈递任务
    public void submit(Runnable task) throws InterruptedException {
        blockingQueue.put(task);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(10);
        for (int i = 0;i<1000;i++) {
            int id = i;
            myThreadPool.submit(()->{
                System.out.println(Thread.currentThread().getName()+" "+id);
            });
        }

        Thread.sleep(1000);
        System.out.println("over...");
    }
}
