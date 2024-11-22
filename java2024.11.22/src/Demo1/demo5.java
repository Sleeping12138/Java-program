package Demo1;

import java.util.Scanner;

public class demo5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) array[i] = in.nextInt();
        int[] sum = new int[N + 1];
        for (int i = 1; i < N + 1; i++) sum[i] = sum[i - 1] + array[i - 1];

        int[][] dp = new int[N][N];
        for(int i = N-1;i>=0;i--){
            for(int j = i;j<N;j++){
                for(int k = i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+sum[j+1]-sum[i]);
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }
}
