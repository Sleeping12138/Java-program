package Demo1;

import java.util.Scanner;

// 多重背包问题
public class demo2 {
    // 将每个物品分割之后最大需要的存储空间
    public static final int NUMBER = 11010;
    public static int[] v = new int[NUMBER];
    public static int[] w = new int[NUMBER];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), V = in.nextInt();

        // 将物品通过二进制优化之后填入数组中
        int index = 0;
        for (int i = 0; i < N; i++) {
            int a = in.nextInt(), b = in.nextInt(), s = in.nextInt();
            int k = 1;
            while (s >= k) {
                v[index] = k * a;
                w[index] = k * b;
                s -= k;
                k *= 2;
                index++;
            }
            if (s > 0) {
                v[index] = s * a;
                w[index] = s * b;
                index++;
            }
        }

        // 01背包问题
        int[][] dp = new int[index + 1][V + 1];
        for (int i = 1; i < index + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                dp[i][j] = j - v[i - 1] >= 0 ? Math.max(dp[i - 1][j], dp[i - 1][j - v[i - 1]] + w[i - 1]) : dp[i - 1][j];
            }
        }

        System.out.println(dp[index][V]);
    }
}
