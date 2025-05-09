package Demo;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class code5 {
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
