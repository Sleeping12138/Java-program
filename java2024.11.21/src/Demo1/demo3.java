package Demo1;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int number = in.nextInt();
            if (number % 2 == 0) System.out.println(number);
            else {
                String str = String.valueOf(number);
                StringBuilder sb = new StringBuilder(str);
                boolean flag = true;

                for (int j = 0; j < sb.length(); j++) {
                    char ch = sb.charAt(j);
                    if ((ch - '0') % 2 == 0) {
                        sb.deleteCharAt(j);
                        sb.append(ch);
                        while(sb.charAt(0)=='0') sb.deleteCharAt(0);
                        flag = false;
                        break;
                    }
                }

                if (flag) System.out.println(-1);
                else System.out.println(sb.toString());
            }
        }

    }
}
