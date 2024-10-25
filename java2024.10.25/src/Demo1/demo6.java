package Demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class demo6 {

    private static int number = 0;
    public static void main(String[] args) throws InterruptedException {
        // 使用ReentrantLock来实现生产者消费者模型
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Thread thread1 = new Thread(()->{
            while (true) {
                try {
                    reentrantLock.lock();
                    while(number>=100){
                        condition.await();
                    }
                    number++;
                    System.out.println(Thread.currentThread().getName()+"  "+number);
                    condition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                }
            }
        },"生产者");

        Thread thread2 = new Thread(()->{
            while (true) {
                try {
                    reentrantLock.lock();
                    while(number<=0){
                        condition.await();
                    }
                    number--;
                    System.out.println(Thread.currentThread().getName()+"  "+number);
                    condition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                }
            }
        },"消费者");

        thread1.start();
        thread2.start();
    }
}
