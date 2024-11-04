package Demo1;

import java.math.BigInteger;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int x = in.nextInt();
            int[] array = new int[n];
            for(int i = 0;i<n;i++) array[i]=in.nextInt();

            for(int number : array){
                if(x>=number){
                    x+=number;
                }else{
                    BigInteger temp1 = new BigInteger(String.valueOf(x));
                    BigInteger temp2 = new BigInteger(String.valueOf(number));
                    BigInteger temp3 = temp1.gcd(temp2);
                    x+=temp3.intValue();
                }
            }
            System.out.println(x);
        }
    }
}
