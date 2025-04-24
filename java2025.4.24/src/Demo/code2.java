package Demo;

public class code2 {
    public String decodeString(String s) {
        int[] index = new int[1]; // 用数组来模拟引用传递
        return dfs(s, index);
    }

    private String dfs(String s, int[] i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;

        while (i[0] < s.length()) {
            char ch = s.charAt(i[0]);

            if (Character.isDigit(ch)) {
                multi = multi * 10 + (ch - '0');
            } else if (ch == '[') {
                i[0]++; // 跳过 '['
                String inner = dfs(s, i);
                // 重复 inner 字符串 multi 次
                for (int j = 0; j < multi; j++) {
                    res.append(inner);
                }
                multi = 0;
            } else if (ch == ']') {
                break; // 当前这段结束了
            } else {
                res.append(ch); // 普通字符直接拼接
            }

            i[0]++;
        }

        return res.toString();
    }
}
