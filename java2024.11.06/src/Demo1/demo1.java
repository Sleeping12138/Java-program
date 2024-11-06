package Demo1;

import java.util.HashSet;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            char[] chs = str.toCharArray();
            int n = chs.length;

            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) set.add(chs[i]);

            if (set.size() == 1) System.out.println(0);
            else System.out.println(isHui(str) ? n - 1 : n);
        }
    }

    public static boolean isHui(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
}
