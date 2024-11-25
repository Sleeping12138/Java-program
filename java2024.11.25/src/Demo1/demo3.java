package Demo1;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) {
            int n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
            long sum = 0;
            if (n <= 2) sum = Math.min(a, b);
            else if (n == 3) sum = Math.min(2 * a, b);
            else {
                int sum1 = 0;
                sum1 += (n / 2) * a;
                sum1 += (n % 2) * Math.min(a, b);

                int sum2 = 0;
                sum2 += (n / 3) * b;
                if (n % 3 != 0) {
                    sum2 += Math.min(a, b);
                }

                sum = Math.min(sum1, sum2);
            }
            System.out.println(sum);
        }
    }
}


