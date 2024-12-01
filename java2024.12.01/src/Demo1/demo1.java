package Demo1;

import java.util.Arrays;

class demo1 {
    private static final int MOD = (int) (1e9 + 7);
    public static int min, max;

    public int count(String num1, String num2, int minSum, int maxSum) {
        min = minSum;
        max = maxSum;
        int ans = calc(num2) - calc(num1) + MOD; // 避免负数
        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += c - '0';
        }
        if (minSum <= sum && sum <= maxSum) {
            ans++; // num1 是合法的，补回来
        }
        return ans % MOD;
    }

    private int calc(String s) {
        int n = s.length();
        int[][] memo = new int[n][220];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, true, s.toCharArray(), memo);
    }

    private int dfs(int i, int sum, boolean isLimit, char[] s, int[][] memo) {
        // 不能产生子问题 —— 不能在递归表达式了
        if (i == s.length) {
            return sum >= min && sum <= max ? 1 : 0;
        }
        if (!isLimit && memo[i][sum] != -1) {
            return memo[i][sum];
        }

        int up = isLimit ? s[i] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= up; d++) {
            res = (res + dfs(i + 1, sum + d, isLimit && (d == up), s, memo)) % MOD;
        }

        if (!isLimit) {
            memo[i][sum] = res;
        }
        return res;
    }
}
