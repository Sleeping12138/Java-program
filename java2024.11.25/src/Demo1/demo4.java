package Demo1;

import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            long x = in.nextLong();
            int[] array = new int[20];
            int index = 0, sum = 0;
            while (x != 0) {
                array[index] = (int) (x % 10);
                sum += array[index];
                index++;
                x /= 10;
            }

            if (sum % 2 != 0) System.out.println("No");
            else {
                int target = sum / 2;
                boolean[][] dp = new boolean[index + 1][target + 1];
                for (int i = 0; i < index + 1; i++) {
                    dp[i][0] = true;
                }

                for (int i = 1; i < index + 1; i++) {
                    for (int j = 1; j < target + 1; j++) {
                        dp[i][j] = j - array[i - 1] >= 0 ? dp[i - 1][j - array[i - 1]] || dp[i - 1][j] : dp[i - 1][j];
                    }
                }
                System.out.println(dp[index][target]?"Yes":"No");

            }

        }
    }
}
