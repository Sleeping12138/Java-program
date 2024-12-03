package Demo1;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char[] ch1 = in.next().toCharArray();
            char[] ch2 = in.next().toCharArray();
            int n1 = ch1.length, n2 = ch2.length;

            int[][] dp = new int[n1 + 1][n2 + 1];
            for (int i = 0; i < n2 + 1; i++) dp[0][i] = i;
            for (int i = 1; i < n1 + 1; i++) dp[i][0] = i;

            for (int i = 1; i < n1 + 1; i++) {
                for (int j = 1; j < n2 + 1; j++) {
                    if (ch1[i] == ch2[j]) dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }

            System.out.println(dp[n1][n2]);
        }
    }
}
