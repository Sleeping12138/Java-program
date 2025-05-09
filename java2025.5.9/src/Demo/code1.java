package Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class code1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = ()->{
            Thread.sleep(1000);
            return 10000;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());
        System.out.println("over");
    }
}
