package Demo1;

import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.next();
            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(1);
            sb.deleteCharAt(4);
            sb.deleteCharAt(9);
            char[] chs = sb.toString().toCharArray();

            int ret = 0;
            for(int i = 0;i<9;i++){
                ret+=(chs[i]-'0')*(i+1);
            }

            StringBuilder sb2 = new StringBuilder(str);
            if((ret%11)==chs[9]) System.out.println("Right");
            else System.out.println(sb2.deleteCharAt(12).append(ret%11).toString());
        }
    }
}
