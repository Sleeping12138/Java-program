package Demo1;

import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();

            // 第二个参数表示字符串为多少进制的数字
            System.out.println(Integer.parseInt(str, 8));
        }
    }
}
