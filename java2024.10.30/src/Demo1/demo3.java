package Demo1;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            long n = in.nextInt();
//            long number1 = (long) Math.ceil(Math.sqrt(n));
//            long number2 = (long) Math.floor(Math.sqrt(n));
//            long num1 = number1 * number1;
//            long num2 = number2 * number2;
//            long ret = Math.abs(num1 - n) > Math.abs(num2 - n) ? num2 : num1;
//            System.out.println(ret);
//
//        }

//        System.out.println(3.14>2);

        PriorityQueue<Double> priorityQueue = new PriorityQueue<>((a,b)->b.compareTo(a));


    }
}

