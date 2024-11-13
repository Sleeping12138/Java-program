package Demo1;

import java.util.concurrent.Semaphore;

//
public class demo5 {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            int number = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "   正在运行...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName() + "   结束运行...");
                    semaphore.release();
                }
            }, "Threar--" + i).start();
        }
    }


}
