package Demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 读写锁的基本使用方式
public class demo2 {
    private int number = 100;
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private final Lock rlock = reentrantReadWriteLock.readLock();
    private final Lock wlock = reentrantReadWriteLock.readLock();


    public demo2() {

    }

    public int getNumber(){
        rlock.lock();
        try {
            System.out.println("读取数据...");
            return this.number;
        }finally {
            rlock.unlock();
        }
    }

    public void writeNumber(int number){
        wlock.lock();
        try {
            System.out.println("修改数据...");
            number = this.number;
        }finally {
            wlock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
