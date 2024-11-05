package Demo1;

import java.util.Scanner;

public class demo1 {
    // 判断100到200之间的素数
//    public static void main(String[] args) {
//        for (int i = 100; i <= 200; i++) {
//            int j = 0;
//            for (j = 2; j <= Math.sqrt(i * 1.0); j++) {
//                if (i % j == 0) {
//                    break;
//                }
//            }
//            if (j > Math.sqrt(i * 1.0)) System.out.println(i);
//        }
//
//    }

//    public static void main(String[] args) {
//        for(int i = 100;i<=200;i++){
//            boolean flag = false;
//            for(int j = 2;j<Math.sqrt(i*1.0);j++){
//                if(i%j==0) {
//                    flag=true;
//                    break;
//                }
//            }
//            if(!flag) System.out.println(i);
//        }
//    }

    // 求最小公倍数
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int a = in.nextInt(),b = in.nextInt();
//        int top = a*b,max = Math.max(a, b);
//        for(int i = max;i<=top;i++){
//            if(i%a==0&&i%b==0){
//                System.out.println(i);
//                break;
//            }
//        }
//    }

    // 求最大公约数
    public static void main(String[] args) {
        int a = 4, b = 6;
        int c = a % b;
        while (c != 0) {
            a = b;
            b = c;
            c = a % b;
        }
        System.out.println(b);

        System.out.println(4*6/b);
    }
}
