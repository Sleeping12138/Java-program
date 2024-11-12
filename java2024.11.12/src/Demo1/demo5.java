package Demo1;

import java.util.Timer;
import java.util.TimerTask;

public class demo5 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        },1000);

        Timer timer1 = new Timer();
        timer1.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        },0,1000);
    }
}
