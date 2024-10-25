package Demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class demo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int ret = 0;
                for (int i = 1; i <= 10; i++) {
                    ret+=i;
                }
                return ret;
            }
        };

        // 使用futureTask接收callable的返回值
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        // 打印结果
        System.out.println(futureTask.get());


    }
}
