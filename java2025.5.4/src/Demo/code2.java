package Demo;

public class code2 {
    public static void main(String[] args) {

    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] f = new int[n];
        int[] g = new int[n];
        int[] t = new int[n];

        g[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1], t[i - 1]);
            g[i] = Math.max(f[i - 1] - prices[i], g[i - 1]);
            t[i] = g[i - 1] + prices[i];
        }

        return Math.max(t[n - 1], f[n - 1]);
    }
}
