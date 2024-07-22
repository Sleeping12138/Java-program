package Demo1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {6, 1, 8, 9, 10, 4, 2, 5, 3, 7};
        Sort sort = new Sort();
        sort.quickSort3(array);

        System.out.println(Arrays.toString(array));

    }
}
