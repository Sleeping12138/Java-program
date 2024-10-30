package Demo1;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] array = new int[n];
            for(int i = 0;i<n;i++) array[i] = in.nextInt();

            int[] dpf = new int[n];
            int[] dpg = new int[n];
            dpg[0] = array[0];
            for(int i = 1;i<n;i++){
                dpf[i] = Math.max(dpf[i-1],dpg[i-1]);
                dpg[i] = dpf[i-1]+array[i];
            }

            System.out.println(Math.max(dpf[n-1],dpg[n-1]));
        }
    }
}
