package Demo1;

import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char[] chs1 = in.next().toCharArray();
            char[] chs2 = in.next().toCharArray();
            char[] strs = new char[26];
            for (char ch : chs2) {
                strs[ch - 'A']++;
            }
            for (char ch : chs1) {
                strs[ch - 'A']--;
            }

            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (strs[i] > 0) flag = false;
            }
            if (!flag) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}
