package Demo;

import java.util.Scanner;

public class code1 {
    private static int number = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (number == 0) {

            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                Scanner in = new Scanner(System.in);
                System.out.print("请输入number：");
                number = in.nextInt();
                System.out.println(number);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(number);
    }
}
