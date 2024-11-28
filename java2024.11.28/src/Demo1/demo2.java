package Demo1;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), V = in.nextInt();
        int[][] v = new int[n][100];
        int[][] w = new int[n][100];
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            len[i] = s;
            for (int j = 0; j < s; j++) {
                v[i][j] = in.nextInt();
                w[i][j] = in.nextInt();
            }
        }

        int[][] dp = new int[n + 1][V + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                for (int k = 0; k < len[i - 1]; k++) {
                    if (j - v[i - 1][k] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i - 1][k]]);
                    }
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        System.out.println(dp[n][V]);
    }
}
