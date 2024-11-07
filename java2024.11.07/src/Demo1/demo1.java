package Demo1;

import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char[] ch1 = in.next().toCharArray();
            char[] ch2 = in.next().toCharArray();
            int n1 = ch1.length;
            int n2 = ch2.length;

            int[][] dp = new int[n1 + 1][n2 + 1];
            int max = 0;
            for (int i = 1; i < n1 + 1; i++) {
                for (int j = 1; j < n2 + 1; j++) {
                    if (ch1[i-1] == ch2[j-1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }

            System.out.println(n1 - max);

        }
    }
}
