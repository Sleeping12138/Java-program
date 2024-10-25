package Demo1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class demo8 {
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public static void main(String[] args) {
        // 读写锁的创建
        //......

    }

    public static void read() throws InterruptedException {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + " " + "正在读取");
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " " + "读取完毕");
        readLock.unlock();
    }

    public static void write() throws InterruptedException {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + " " + "正在写入");
        Thread.sleep(2000);
        writeLock.unlock();
    }
}

/*
* 读写锁
* Callable
* ReentrantLock
* Semaphore
* */
