package Demo1;

import java.util.ArrayList;
import java.util.Scanner;

// 问题： 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m，要求将其中所有的可能组合列出来。

public class demo2 {
    public static ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int prev = 0;
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            n = in.nextInt();
            int m = in.nextInt();
            dfs(m);

            for (int i = 0; i < ret.size(); i++) {
                for (int j = 0; j < ret.get(i).size(); j++) {
                    System.out.print(ret.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    private static void dfs(int target) {
        if (target == 0) {
            // 注意：由于添加的是引用数据类型，其会在递归的时候内部数据进行改变，所以要重新创建一个新的
            ret.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) return;

        int begin = prev;
        for (int i = 1; i <= n; i++) {
            if (i > prev) {
                prev = i;
                list.add(i);
                dfs(target - i);
                list.remove(list.size() - 1);
                prev = begin;
            }
        }
    }
}
