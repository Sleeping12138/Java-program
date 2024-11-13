package Demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Callable接口的使用
public class demo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int ret = 0;
                for (int i = 0; i < 100; i++) {
                    ret+=i;
                }
                return ret;
            }
        };

        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 100;
            }
        });
        Thread thread = new Thread(integerFutureTask);
        thread.start();
        System.out.println(integerFutureTask.get());
    }
}
