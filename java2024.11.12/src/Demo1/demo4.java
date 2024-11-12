package Demo1;

import java.util.Timer;
import java.util.TimerTask;

// 定时器的使用
public class demo4 {
    public static void main(String[] args) {
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("hello world");
//            }
//        },1000);


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        },0,1000);
    }
}
