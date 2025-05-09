package Demo;

import java.util.concurrent.Semaphore;

public class code2 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            final int number = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread() + "正在执行任务" + number);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    semaphore.release();
                }
            }).start();
        }

        System.out.println("over");
    }
}
