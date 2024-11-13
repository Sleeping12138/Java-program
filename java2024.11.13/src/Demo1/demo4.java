package Demo1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// ReentrantLock类的使用
public class demo4 {
    private static ReentrantLock reentrantLock = new ReentrantLock(true);
    private static Condition condition = reentrantLock.newCondition();

    private static BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

    private static int number = 0;

    private static int MAXNUMBER = 100;

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(() -> {
            while (true) {
                reentrantLock.lock();
                try {
                    while (blockingQueue.size() == MAXNUMBER) {
                        condition.await();
                    }
                    number++;
                    blockingQueue.put(number);
                    System.out.println(Thread.currentThread().getName() + " " + number);
                    condition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        producer.start();


//        ReentrantLock reentrantLock = new ReentrantLock();
//        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                reentrantLock.lock();
//                try {
//                    System.out.println(Thread.currentThread().getName() + " " + i);
//                } finally {
//                    reentrantLock.unlock();
//                }
//            }
//        });


//        ReentrantLock reentrantLock = new ReentrantLock();
//        if (reentrantLock.tryLock(3, TimeUnit.SECONDS)) {
//            System.out.println("获取锁成功...");
//        } else {
//            System.out.println("没有获取锁...");
//        }


    }
}
