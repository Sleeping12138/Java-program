package Demo1;

import java.util.Arrays;

class demo1 {
    public char[] chs;
    public int[] memo;

    public int rotatedDigits(int n) {
        chs = String.valueOf(n).toCharArray();
        int len = chs.length;
        memo = new int[len];
        Arrays.fill(memo, -1);
        return dfs(0, true, false);
    }

    public int dfs(int i, boolean isUp, boolean isNum) {
        if (i == chs.length)
            return isNum ? 1 : 0;
        if (!isUp && isNum && memo[i] != -1)
            return memo[i];

        int ret = 0;
        int up = isUp ? chs[i] - '0' : 9;
        for (int j = 0; j <= up; j++) {
            if (j == 3 || j == 4 || j == 7)
                continue;
            else if (j == 0 || j == 1 || j == 8)
                ret += dfs(i + 1, isUp && j == up, isNum || false);
            else
                ret += dfs(i + 1, isUp && j == up, true);
        }

        if (!isUp && isNum)
            memo[i] = ret;
        return ret;
    }
}
