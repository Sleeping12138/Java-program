package Demo1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class demo4 {

    private final int capacity = 5;
    private BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(capacity);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    // 生产者方法
    public void produce(int value) throws InterruptedException {
        lock.lock();  // 加锁
        try {
            while (blockingQueue.size() == capacity) {
                System.out.println("Buffer is full. Producer is waiting.");
                condition.await();
            }
            blockingQueue.add(value);
            System.out.println("Produced: " + value);
            condition.signal();
        } finally {
            lock.unlock();  // 解锁
        }
    }

}
