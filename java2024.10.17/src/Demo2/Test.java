package Demo2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();

            int[][] dp = new int[n+1][m+1];
            dp[0][0] = 1;
            for(int i = 1;i<n+1;i++){
                for(int k = 1;k<m+1;k++){
                    if(Math.abs(i-x)+Math.abs(k-y)==3||(i==x&&k==y)) dp[i][k]=0;
                    else dp[i][k] = dp[i-1][k]+dp[i][k-1];
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
