package Demo1;

import java.util.Arrays;

class Solution {
    public int countSpecialNumbers(int n) {
        // 将 n 转换为字符数组，方便逐位处理每个数字
        char[] digits = Integer.toString(n).toCharArray();

        // memo[i][mask] 存储处理到第 i 位，已经使用过数字集合的结果
        // mask 用一个二进制数表示已经使用的数字，1 表示数字已使用，0 表示未使用
        int[][] memo = new int[digits.length][1 << 10];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示该状态未计算过
        }

        // 从第 0 位开始处理，初始时数字集合为空，n 的限制为 true
        return dfs(0, 0, true, false, digits, memo);
    }

    // dfs 函数：处理当前位 i，已使用的数字集合 mask，是否受 n 限制 isLimit，当前数字是否有效 isNum
    private int dfs(int i, int mask, boolean isLimit, boolean isNum, char[] digits, int[][] memo) {
        // 如果已经处理完所有位，判断是否构造了一个有效数字
        if (i == digits.length) {
            return isNum ? 1 : 0; // 如果当前数字有效，返回 1，否则返回 0
        }

        // 如果当前状态已经计算过，直接返回记忆化的结果
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }

        int res = 0; // 存储当前状态下的结果

        // 如果当前还没有开始构造有效数字，可以跳过当前位，继续处理下一位
        if (!isNum) {
            res = dfs(i + 1, mask, false, false, digits, memo);
        }

        // 当前位可以填的最大数字是 s[i]，即 n 对应位的数字
        int maxDigit = isLimit ? digits[i] - '0' : 9;

        // 枚举当前位可以填的数字 d
        // 如果前面没有填数字，则从 1 开始（避免前导零），否则从 0 开始
        for (int d = isNum ? 0 : 1; d <= maxDigit; d++) {
            // 检查数字 d 是否已经使用过（通过 mask 判断）
            if ((mask >> d & 1) == 0) {
                // 递归处理下一位，更新 mask（将 d 标记为已使用），并决定是否继续受限于 n
                res += dfs(i + 1, mask | (1 << d), isLimit && d == maxDigit, true, digits, memo);
            }
        }

        // 如果不再受 n 限制，且已经构造了有效数字，记录当前状态的结果
        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }

        return res;
    }
}

