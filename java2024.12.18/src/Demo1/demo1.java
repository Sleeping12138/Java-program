package Demo1;

public class demo1 {
    // 创建辅助数组
    public int[] createTemp(char[] pattern) {
        int[] temp = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[index]) {
                temp[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = temp[index - 1];
                } else {
                    temp[i] = 0;
                    i++;
                }
            }
        }
        return temp;
    }

    // KMP算法
    public boolean KMP(char[] text, char[] pattern) {
        int[] temp = createTemp(pattern);
        int i = 0,j = 0;
        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = temp[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == pattern.length;
    }


}
