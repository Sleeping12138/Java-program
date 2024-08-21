package Demo2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = {2,7,8,1,6,4,5,9,3,10};
        sort.countSort(array);
        System.out.println(Arrays.toString(array));

    }
}
