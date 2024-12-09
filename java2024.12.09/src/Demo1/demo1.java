package Demo1;

import java.util.Arrays;

public class demo1 {
    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) array[i] = i;
        array = Arrays.copyOf(array, 10);
        System.arraycopy(array, 0, array, 5, 5);
        System.out.println(Arrays.toString(array));
    }
}
