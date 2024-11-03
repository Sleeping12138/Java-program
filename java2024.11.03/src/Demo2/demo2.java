package Demo2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt(), k = in.nextInt();
            int[][] food = new int[2][n];
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            for(int i = 0;i<n;i++) {
                food[0][i] = in.nextInt();
                priorityQueue.offer(food[0][i]);
            }
            for(int i = 0;i<n;i++) food[1][i]= in.nextInt();

            int sweat = 0,sour = 0;
            for(int i = 0;i<k;i++){

            }


        }
    }
}
