package Demo1;

import java.util.Arrays;

class demo3 {
    public char[] chs;
    public int[][] memo;

    public int numberOf2sInRange(int n) {
        chs = String.valueOf(n).toCharArray();
        int len = chs.length;
        memo = new int[len][10];
        for (int i = 0; i < len; i++)
            Arrays.fill(memo[i], -1);
        return dfs(0, 0, true);
    }

    public int dfs(int i, int sum, boolean isUp) {
        if (i == chs.length)
            return sum;
        if (!isUp && memo[i][sum] != -1)
            return memo[i][sum];

        int ret = 0;
        int up = isUp ? chs[i] - '0' : 9;
        for (int j = 0; j <= up; j++) {
            ret += dfs(i + 1, j == 2 ? sum + 1 : sum, isUp && j == up);
        }
        if (!isUp)
            memo[i][sum] = ret;
        return ret;
    }
}
