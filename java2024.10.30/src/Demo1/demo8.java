package Demo1;

import java.math.BigInteger;

public class demo8 {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("20");
        BigInteger bigInteger1 = BigInteger.valueOf(10);
//        System.out.println(bigInteger);
//        System.out.println(bigInteger1);
        System.out.println(bigInteger1.add(bigInteger));
        System.out.println(bigInteger1.subtract(bigInteger));
        System.out.println(bigInteger1.multiply(bigInteger));
        System.out.println(bigInteger1.divide(bigInteger));
        System.out.println(bigInteger1.mod(bigInteger));
    }
}
