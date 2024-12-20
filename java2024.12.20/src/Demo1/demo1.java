package Demo1;

import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong(), b = in.nextLong(), n = in.nextLong();
        long ret = (n / (5 * a + 2 * b) )* 7, temp = n % (5 * a + 2 * b);
        for (int i = 1; i <= 7; i++) {
            if (i <= 5) {
                temp -= a;
            } else {
                temp -= b;
            }
            ret++;
            if (temp <= 0) break;
        }

        System.out.println(ret);
    }
}
