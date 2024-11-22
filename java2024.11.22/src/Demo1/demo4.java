package Demo1;

import java.util.Scanner;

// 分组背包问题
public class demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), V = in.nextInt();
        int[][] v = new int[N][110];
        int[][] w = new int[N][110];

        // 用于记录每组的长度
        int[] groupLen = new int[N];

        for (int i = 0; i < N; i++) {
            int s = in.nextInt();
            groupLen[i] = s;
            for (int j = 0; j < s; j++) {
                v[i][j] = in.nextInt();
                w[i][j] = in.nextInt();
            }
        }

        // 转变为了一组中要哪个
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                for (int k = 0; k < groupLen[i - 1]; k++) {
                    if (j >= v[i - 1][k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i - 1][k]] + w[i - 1][k]);
                    }
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
            }
        }

        System.out.println(dp[N][V]);
    }
}
