package Demo1;

import java.util.Arrays;

class demo1 {
    char[] ch1, ch2, ss;
    int n1, n2, isLimit;
    long[] memo;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String temp1 = String.valueOf(start), temp2 = String.valueOf(finish);
        n1 = temp1.length();
        n2 = temp2.length();
        int n = n2 - n1;
        for (int i = 0; i < n; i++)
            temp1 = "0" + temp1;
        ch1 = temp1.toCharArray();
        ch2 = temp2.toCharArray();
        ss = s.toCharArray();
        isLimit = limit;
        memo = new long[n2];
        Arrays.fill(memo, -1);
        return dfs(0, true, true);
    }

    public long dfs(int i, boolean isLow, boolean isUp) {
        if (i == n2)
            return 1;
        if (!isLow && !isUp && memo[i] != -1)
            return memo[i];

        int low = isLow ? ch1[i] - '0' : 0;
        int up = isUp ? ch2[i] - '0' : 9;

        int diff = n2 - ss.length;
        long ret = 0;
        if (i < diff) {
            for (int j = low; j <= Math.min(up, isLimit); j++) {
                ret += dfs(i + 1, isLow && j == low, isUp && j == up);
            }
        } else {
            int x = ss[i - diff] - '0';
            if (x >= low && x <= Math.min(up, isLimit)) {
                ret = dfs(i + 1, isLow && x == low, isUp && x == up);
            }
        }

        if (!isLow && !isUp)
            memo[i] = ret;
        return ret;
    }
}
