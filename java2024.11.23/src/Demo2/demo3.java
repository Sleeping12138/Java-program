package Demo2;

import java.util.Arrays;
import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt(),k = in.nextInt();
            int[] array = new int[n];
            for(int i = 0;i<n;i++) array[i] = in.nextInt();

            Arrays.sort(array);

            int left = 0,right = n-1,ret = n;
            while(Math.abs(array[right]-array[left])>k){
                right--;
                ret--;
            }
            System.out.println(ret);
        }
    }
}
