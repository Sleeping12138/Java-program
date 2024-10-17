package Demo1;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();


        synchronized (locker) {

            locker.notify();// 唤醒wait线程

        }
    }

}
