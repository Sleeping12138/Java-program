package Demo2;

import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            char[] chs = new char[26];
            boolean[] flag = new boolean[26];
            char[] str = in.next().toCharArray();
            for (char ch : str) {
                chs[ch - 'a']++;
                flag[ch - 'a'] = true;
            }

            int maxn = 0, minn = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (chs[i] < minn && flag[i]) minn = chs[i];
                if (chs[i] > maxn) maxn  = chs[i];
            }

            int result = maxn - minn;
            boolean ret = isZhi(result);
            if (ret) {
                System.out.println("Lucky Word");
                System.out.println(result);
            } else {
                System.out.println("No Answer");
                System.out.println(0);
            }

        }
    }
    public static boolean isZhi(int number) {
        if (number == 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
