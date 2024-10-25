package Demo1;

import java.util.concurrent.Semaphore;

public class demo7 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "  " + "正在执行...");
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "  " + "结束执行...");
                }
            }).start();
        }


    }
}
