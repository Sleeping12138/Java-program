package Demo1;

import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt(),h = in.nextInt(),b = in.nextInt(),k = in.nextInt();
            long ret = 0;
            while(h>0&&k>0){
                ret+=(a+b);
                h-=b;
                k-=a;
            }
            if(h>0) ret+=10*a;
            if(k>0) ret+=10*b;

            System.out.println(ret);
        }
    }
}
