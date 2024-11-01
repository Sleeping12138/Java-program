package Demo1;

import java.util.Arrays;
import java.util.Scanner;

public class demo4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n=in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0;i<n;i++) a[i] = in.nextInt();
            for(int i = 0;i<n;i++) b[i] = in.nextInt();

            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(b));
        }
    }
}
