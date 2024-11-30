package Demo1;

import java.util.Arrays;

class demo2 {
    public char[] chs;
    public int[][] memo;
    public int countSpecialNumbers(int number) {
        // 转换为数组之后便于取数
        chs = Integer.toString(number).toCharArray();
        int n = chs.length;
        // 使用了位图的思想
        memo = new int[n][1 << 10];
        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);
        return dfs(0, 0, true, false);
    }
    // 函数表示从i位置开始，满足条件的数目
    public int dfs(int i, int mark, boolean isLimit, boolean isNum) {
        // 递归终止条件
        if (i == chs.length)
            return isNum ? 1 : 0;
        // 记忆化搜索
        if (!isLimit && isNum && memo[i][mark] != -1)
            return memo[i][mark];
        // 递归表达式
        int ret = 0;
        // 不填 - 有先决条件
        if (!isNum) {
            ret += dfs(i + 1, mark, false, false);
        }
        // 填入
        int top = isLimit ? chs[i] - '0' : 9;
        int low = isNum ? 0 : 1;
        for (int j = low; j <= top; j++) {
            if (((mark >> j) & 1) == 0) {
                ret += dfs(i + 1, (1 << j) | mark, isLimit && j == top, true);
            }
        }
        // 记忆化搜索
        if (!isLimit && isNum)
            memo[i][mark] = ret;
        return ret;
    }
}
