package Demo2;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt(),p = in.nextInt();
            int[] a = new int[n];
            int max = 0,min= Integer.MAX_VALUE;
            for(int i = 0;i<n;i++) {
                a[i] = in.nextInt();
                if(a[i]>max) max = a[i];
                if(a[i]<min) min = a[i];
            }

            int ret = 0;
            for(int i = min;i<=max;i++){
                int low = i-p,top = i+p,count = 0;
                for(int j = 0;j<n;j++){
                    if(a[j]>=low&&a[j]<=top) count++;
                }
                ret=Math.max(ret,count);
            }

            System.out.println(ret);
        }
    }
}
