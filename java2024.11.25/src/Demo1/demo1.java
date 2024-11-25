package Demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class demo1 {
    public static void main(String[] args) {
        // 使用sort对二维数组进行排序
//        int[][] array = {
//                {3, 2},
//                {1, 4},
//                {2, 5}
//        };
//
//        Arrays.sort(array,(a,b)->a[0]-b[0]);
//        System.out.println(Arrays.deepToString(array));

//        Integer[] array = {9,8,7,6,5,4,3,2,1};
//        Arrays.sort(array,(o1,o2)->o2-o1);
//        System.out.println(Arrays.toString(array));

//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });

//        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o2[0]-o1[0]);

//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        list.sort((o1,o2)->o2.get(0)-o1.get(0));

        int[] array = {1,6,2,8,9,3,4,7,5,0};
        Arrays.sort(array);
        int left = 0,right = array.length - 1;
        while (left<right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(array));


    }
}
