package Demo1;

import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(getTen(number));
        System.out.println(getTenOfString(String.valueOf(number)));

    }

    public static int getTenOfString(String number) {
        char[] chs = number.toCharArray();
        int n = chs.length, sum = 0, index = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 每一位进行运算2^n
            sum += (int) ((chs[i] - '0') * Math.pow(2, index++));
        }
        return sum;
    }

    public static int getTen(int number) {
        int sum = 0, index = 0;
        while (number != 0) {
            int temp = number % 10;
            sum += (int) (temp * Math.pow(2, index));
            number /= 10;
            index++;
        }
        return sum;
    }
}
