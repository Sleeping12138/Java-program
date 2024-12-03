package Demo1;

import java.util.Arrays;

class demo1 {
    public char[] low;
    public char[] high;
    public char[] ss;
    public long[] memo;
    public int limitTop;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String lowStr = Long.toString(start);
        String highStr = Long.toString(finish);
        int n = highStr.length();
        int m = lowStr.length();
        for (int i = 0; i < n - m; i++) {
            lowStr = "0" + lowStr;
        }
        low = lowStr.toCharArray();
        high = highStr.toCharArray();
        limitTop = limit;
        ss = s.toCharArray();
        memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(0, true, true);
    }

    private long dfs(int i, boolean limitLow, boolean limitHigh) {
        if (i == high.length) {
            return 1;
        }

        if (!limitLow && !limitHigh && memo[i] != -1) {
            return memo[i];
        }

        // 第 i 个数位可以从 lo 枚举到 hi
        // 如果对数位还有其它约束，应当只在下面的 for 循环做限制，不应修改 lo 或 hi
        int hi = limitHigh ? high[i] - '0' : 9;
        int lo = limitLow ? low[i] - '0' : 0;

        long res = 0;
        int diff = high.length - ss.length;
        if (i < diff) { // 枚举这个数位填什么
            for (int d = lo; d <= Math.min(hi, limitTop); d++) {
                res += dfs(i + 1, limitLow && d == lo, limitHigh && d == hi);
            }
        } else { // 这个数位只能填 s[i-diff]
            int x = ss[i - diff] - '0';
            if (lo <= x && x <= Math.min(hi, limitTop)) {
                res = dfs(i + 1, limitLow && x == lo, limitHigh && x == hi);
            }
        }

        if (!limitLow && !limitHigh) {
            memo[i] = res;
        }
        return res;
    }
}
