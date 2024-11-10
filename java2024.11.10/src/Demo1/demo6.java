package Demo1;

import java.util.Scanner;

//内存可见性问题
public class demo6 {
    public volatile static int flag = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            while(flag == 0){
//                System.out.println("hello");
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入内容: ");
            flag  = scanner.nextInt();
            System.out.println("Thread2 is over...");
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
