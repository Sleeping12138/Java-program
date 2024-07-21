package Demo3;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {2, 6, 9, 10, 5, 7, 8, 1, 3, 6, 4};
        insertSortTime(array);
        shellInsertSort(array);
    }

    public static void insertSortTime(int[] array){
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        Sort sort = new Sort();
        long begin =  System.currentTimeMillis();
        sort.insertSort(arrayCopy);
        long end =  System.currentTimeMillis();
        System.out.println(end - begin);
    }

    public static void shellInsertSort(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array,array.length);
        Sort sort = new Sort();
        long begin = (int) System.currentTimeMillis();
        sort.shellSort(arrayCopy);
        long end = (int) System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
