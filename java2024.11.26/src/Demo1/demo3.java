package Demo1;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<i;j++){
                dp[i] += dp[j];
            }
        }

        System.out.println(dp[n]);
    }
}
