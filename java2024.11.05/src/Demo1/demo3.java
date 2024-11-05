package Demo1;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char[] chs = in.next().toCharArray();
            int n = chs.length;
            boolean[][] dp = new boolean[n][n];
            int len = 0;
            for (int i = n-1; i >=0; i--) {
                for (int j = 0; j < n; j++) {
                    if (chs[i] != chs[j]) {
                        dp[i][j] = false;
                        len = Math.max(len, j - i + 1);
                    } else {
                        dp[i][j] = i + 1 < j ? dp[i + 1][j - 1] : true;
                        if (!dp[i][j]) {
                            len = Math.max(len, j - i + 1);
                        }
                    }
                }
            }
            System.out.println(len);
        }
    }
}
