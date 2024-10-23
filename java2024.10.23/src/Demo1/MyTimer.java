package Demo1;

import java.util.PriorityQueue;

// 自我实现定时器
class MyTimerTask implements Comparable<MyTimerTask> {
    public Runnable task;
    public long time;

    public MyTimerTask(Runnable task, long time) {
        this.task = task;
        this.time = time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return (int) (this.time - o.time);
    }

    public long getTime() {
        return time;
    }

    public void runTask() {
        task.run();
    }
}

public class MyTimer {
    private PriorityQueue<MyTimerTask> priorityQueue = new PriorityQueue<>();
    private Object locker = new Object();

    public void shedule(Runnable task, long time) {
        synchronized (locker) {
            MyTimerTask myTimerTask = new MyTimerTask(task, System.currentTimeMillis() + time);
            priorityQueue.offer(myTimerTask);
            locker.notify();
        }

    }

    public MyTimer() {

        Thread thread = new Thread(() -> {
            while (true) {
                synchronized (locker) {
                    while (priorityQueue.isEmpty()) {
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    MyTimerTask task = priorityQueue.peek();
                    if (task.getTime() > System.currentTimeMillis()) {
                        try {
                            locker.wait(task.getTime() - System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        task.runTask();
                        priorityQueue.poll();
                    }
                }
            }
        });
        thread.start();
    }


    public static void main(String[] args) throws InterruptedException {
        MyTimer myTimer = new MyTimer();
        myTimer.shedule(() -> {
            System.out.println("hello world");
        }, 1000);

        Thread.sleep(2000);

        System.out.println("over");
    }
}
