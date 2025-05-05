package Demo;

public class code4 {
    public static void main(String[] args) {

    }

    public static int countSubstrings(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        boolean[][] dp = new boolean[n][n];

        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (chs[i] == chs[j]) {
                    if (i == j || i + 1 == j)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j])
                    sum++;
            }
        }
        return sum;
    }
}
