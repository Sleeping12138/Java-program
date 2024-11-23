package Demo2;

public class demo2 {
    public static void main(String[] args) {
        int[] a = {-1,-2,-3};
        System.out.println(LIS(a));
    }

    public static int LIS(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                if (a[i] > a[i - j]) {
                    dp[i] = Math.max(dp[i], dp[i - j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
