package Demo1;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {

    public static void main(String[] args) {
        Timer timer = new Timer();
        int totalExecutions = 5; // 假设我们希望任务执行5次后自动关闭

        TimerTask task = new TimerTask() {
            private int executionCount = 0;

            @Override
            public void run() {
                executionCount++;
                System.out.println("任务执行 " + executionCount);

                if (executionCount >= totalExecutions) {
                    timer.cancel();
                    System.out.println("所有任务已完成，定时器已关闭");
                }
            }
        };

        // 每秒执行一次任务
        timer.scheduleAtFixedRate(task, 0, 1000);
    }


}

