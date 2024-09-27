package Demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int q = in.nextInt();
//
//            int[][] array = new int[q][3];
//            for(int i = 0;i<q;i++){
//                for(int k = 0;k<3;k++){
//                    array[i][k] = in.nextInt();
//                }
//            }
//
//            System.out.println(Arrays.deepToString(array));
//
//
//
//        }
//    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(0);
        list2.add(1);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(1);
        list3.add(1);

        grid.add(list1);
        grid.add(list2);
        grid.add(list3);

        System.out.println(rotApple(grid));
    }

    public static int rotApple(ArrayList<ArrayList<Integer>> grid) {
        int maxTime = 0;
        int row = 0;
        int n = grid.size();
        int m = grid.get(0).size();
        boolean[][] flag = new boolean[n][m];
        for (ArrayList<Integer> list : grid) {
            int col = 0;
            for (Integer nowNum : list) {
                if (nowNum == 1) {
                    maxTime = Math.max(maxTime, minTime(grid, row, col));
                }
                col++;
            }
            row++;
        }

        return maxTime;
    }

    public static int minTime(ArrayList<ArrayList<Integer>> array, int i, int j) {
        if ((i < 0 || i >= array.size()) || (j < 0 || j >= array.get(0).size())) return Integer.MAX_VALUE;
        if (array.get(i).get(j) == 0) return Integer.MAX_VALUE;
        if (array.get(i).get(j) == 2) return 0;

        int a = minTime(array, i - 1, j);
        int b = minTime(array, i, j + 1);
        int c = minTime(array, i + 1, j);
        int d = minTime(array, i, j - 1);
        return Math.min(Math.min(a, b), Math.min(c, d));
    }
}
