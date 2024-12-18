package Demo1;

public class demo2 {
    public int[] createTemp(char[] pattern) {
        int n = pattern.length;
        // 创建辅助数组
        int[] temp = new int[n];
        int index = 0;
        for (int i = 1; i < n; ) {
            if (pattern[index] == pattern[i]) {
                // 为当前最长公共前后缀的下一个位置
                temp[i] = index + 1;
                index++;
                i++;
            } else {
                // 回退到0就没必要在进行回退了，直接让它从第一个位置开始匹配
                if (index == 0) {
                    temp[i] = 0;
                    i++;
                } else {
                // 感性理解：在前面的子字符串中找最长公共前后缀
                    index = temp[index - 1];
                }
            }
        }
        return temp;
    }

    public boolean KMP(String str1, String str2) {
        char[] text = str1.toCharArray();
        char[] pattern = str2.toCharArray();
        int[] temp = createTemp(pattern);
        int i = 0, j = 0;
        while (i < text.length && j < temp.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    // 从当前位置开始不可能匹配成功
                    i++;
                } else {
                // 感性理解：在前面的子字符串中找最长公共前后缀
                    j = temp[j - 1];
                }
            }
        }
        return j == temp.length;
    }
}
