package Demo2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt(), k = in.nextInt();
            int[][] array = new int[n][2];
            for (int i = 0; i < n; i++) array[i][1] = in.nextInt();
            for (int i = 0; i < n; i++) array[i][0] = in.nextInt();

            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] o1, int[] o2) -> {
                if (o2[0] != o1[0]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            });

            for (int i = 0; i < n; i++) priorityQueue.offer(array[i]);

            long sweat = 0, sour = 0;
            for (int i = 0; i < k; i++) {
                int[] ret = priorityQueue.poll();
                if (ret != null) {
                    sweat += ret[0];
                    sour += ret[1];
                }
            }

            System.out.println(sour + " " + sweat);
        }
    }
}
