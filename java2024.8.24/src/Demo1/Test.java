package Demo1;

import java.util.Arrays;

public class Test {
//    public static void main(String[] args) {
//        MyBitSet myBitSet = new MyBitSet();
//        myBitSet.set(1);
//        myBitSet.set(2);
//        myBitSet.set(3);
//        myBitSet.set(4);
//        myBitSet.set(10);
//        myBitSet.set(9);
//        myBitSet.set(12);
//        myBitSet.print();

    //    }
    public static void main(String[] args) {


    }

    public static String[] findWords(String[] words) {
        String[] str = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int len = words.length;
        String[] ret = new String[len];
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (words[i].isEmpty())
                continue; // 处理空字符串

            String word = words[i].toLowerCase(); // 转换为小写
            char firstChar = word.charAt(0);
            int index;
            if (str[0].indexOf(firstChar) >= 0) {
                index = 0;
            } else if (str[1].indexOf(firstChar) >= 0) {
                index = 1;
            } else {
                index = 2;
            }

            int k = 0;
            for (; k < word.length(); k++) {
                if (str[index].indexOf(word.charAt(k)) < 0) {
                    break;
                }
            }
            if (k == word.length()) {
                ret[j++] = words[i];
            }
        }
        return Arrays.copyOfRange(ret, 0, j);
    }
}
