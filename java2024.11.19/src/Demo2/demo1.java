package Demo2;

import java.util.*;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char[] chs = in.next().toCharArray();
            int n = chs.length;
            int[][] dp = new int[n][n];
            for(int i = 0;i<n;i++){
                Arrays.fill(dp[i],-1);
            }

            for(int i = n-1;i>=0;i--){
                for(int j = i;j<n;j++){
                    if(chs[i]==chs[j]){
                        if(i==j) dp[i][j] = 1;
                        else if(i+1==j) dp[i][j] = 2;
                        else{
                            if(dp[i+1][j-1]!=-1) dp[i][j] = dp[i+1][j-1]+2;
                        }
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(dp[i][j]!=-1&&dp[i][j]!=1) min = Math.min(min,dp[i][j]);
                }
            }
            System.out.println(min==Integer.MAX_VALUE?-1:min);
        }
    }
}
