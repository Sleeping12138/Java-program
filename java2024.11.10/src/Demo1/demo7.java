package Demo1;

// 死锁问题
public class demo7 {
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (locker1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (locker2){
                    System.out.println("thread1...");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (locker2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (locker1){
                    System.out.println("thread2...");
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
