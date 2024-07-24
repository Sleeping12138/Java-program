package Demo1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {2,6,7,9,10,3,5,8,4,1};
        int[] copyArray1 = Arrays.copyOf(array,array.length);
        int[] copyArray2 = Arrays.copyOf(array,array.length);
        int[] copyArray3 = Arrays.copyOf(array,array.length);
        Sort sort = new Sort();
//        sort.mergeSort(copyArray1);
//        System.out.println(Arrays.toString(copyArray1));
//
//        sort.mergeSortNo(copyArray2);
//        System.out.println(Arrays.toString(copyArray1));
//
//        sort.countSort(copyArray3);
//        System.out.println(Arrays.toString(copyArray3));

        sort.quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));


    }
}
