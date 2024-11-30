package Demo1;

import java.util.Arrays;

class demo1 {
    public char[] s;
    int[][] memo;

    public int countSpecialNumbers(int number) {
        s = Integer.toString(number).toCharArray();
        int n = s.length;
        memo = new int[n][1 << 10];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1);
        return dfs(0, 0, true, false);
    }

    private int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = 0;
        if (!isNum) {
            res = dfs(i + 1, mask, false, false);
        }

        int up = isLimit ? s[i] - '0' : 9;
        int low = isNum ? 0 : 1;

        for (int d = low; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                res += dfs(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }
        return res;
    }
}

