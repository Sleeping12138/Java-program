package Demo1;

public class demo5 {
    public static int number = 0;
    public static void main(String[] args) throws InterruptedException {
        Object locker  = new Object();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                // synchronized为可重入锁
                synchronized (locker) {
                    synchronized (locker) {
                        synchronized (locker) {
                            synchronized (locker) {
                                number++;
                            }
                        }
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                synchronized (locker) {
                    number++;
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(number);

    }
}
