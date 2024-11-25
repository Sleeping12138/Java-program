package Demo1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chs = in.next().toCharArray();
        int n = chs.length;

        int len = Integer.MAX_VALUE;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (chs[i] == chs[j]) dp[i][j] = i + 1 < j ? true : dp[i + 1][j - 1];
                if (dp[i][j] && j - i + 1 >= 2) len = Math.min(len, j - i + 1);
            }
        }

        System.out.println(len == Integer.MAX_VALUE ? -1 : len);

    }
//    public static int minmumNumberOfHost (int n, int[][] startEnd) {
//        Arrays.sort(startEnd,(o1, o2)->o1[0]-o2[0]);
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.offer(startEnd[0][1]);
//
//        for(int i = 1;i<n;i++){
//            int start = startEnd[i][0],end = startEnd[i][1],top= queue.peek();
//            if(start<top) queue.offer(end);
//            else{
//                queue.poll();
//                queue.offer(end);
//            }
//        }
//
//        return queue.size();
//    }
}
