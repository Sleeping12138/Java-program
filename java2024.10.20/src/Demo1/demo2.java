package Demo1;

import java.util.concurrent.atomic.AtomicInteger;

public class demo2 {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        // 启动 5 个线程，每个线程递增计数器 1000 次
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementAndGet();  // 线程安全的递增操作
                }
            }).start();
        }

        // 让主线程稍作等待，确保其他线程执行完成
        try {
            Thread.sleep(2000);  // 简单的等待 2 秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 最后打印计数器的值
        System.out.println("最终计数器的值: " + counter.get());
    }

}
