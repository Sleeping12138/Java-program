package Demo1;

import java.util.Arrays;

public class demo2 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Arrays.fill(array,-1);
        int[] ret = array;
        System.out.println(Arrays.toString(ret));
    }
}
