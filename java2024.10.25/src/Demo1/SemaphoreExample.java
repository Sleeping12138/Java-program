package Demo1;

import java.util.concurrent.Semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static final Semaphore semaphore = new Semaphore(3); // 创建一个信号量

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();
        for (int i = 1; i <= 6; i++) {
            final String taskName = "Task-" + i;
            Thread thread = new Thread(() -> {
                performTask(taskName);
            });
            thread.start();
        }
    }

    public static void performTask(String taskName) {
        try {
            semaphore.acquire();
            System.out.println(taskName + " 开始执行任务" + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(taskName + " 任务完成" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

}

