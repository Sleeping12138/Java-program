package Demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class code4 {
    public static void main(String[] args) {
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
//        scheduledExecutorService.schedule(()->{
//            System.out.println("hello world");
//        },2, TimeUnit.SECONDS);
//
//        scheduledExecutorService.shutdown();
//        System.out.println("over");


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("hello world");
        },0,1,TimeUnit.SECONDS);


    }
}
