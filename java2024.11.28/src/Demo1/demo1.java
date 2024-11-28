package Demo1;

import java.util.Scanner;

public class demo1 {
    public static int N = 710;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), V = in.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt(), b = in.nextInt(), s = in.nextInt();
            int k = 1;
            while (s - k >= 0) {
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

        int[][] dp = new int[index+1][V+1];
        for(int i = 1;i<index+1;i++){
            for(int j = 1;j<V+1;j++){
                dp[i][j] = j-v[i-1]>=0?Math.max(dp[i-1][j],dp[i-1][j-v[i-1]]):dp[i-1][j];
            }
        }
        System.out.println(dp[index][V]);
    }
}
