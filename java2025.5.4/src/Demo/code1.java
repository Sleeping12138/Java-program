package Demo;

public class code1 {
    public static void main(String[] args) {

    }
    public static int jewelleryValue(int[][] frame) {
        int n = frame.length, m = frame[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + frame[i - 1][j - 1];
            }
        }

        return dp[n][m];
    }

}
