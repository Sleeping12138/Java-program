package Demo1;

import java.util.PriorityQueue;

public class demo2 {
    public static void main(String[] args) {

    }
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int ret = 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> o1[0] - o2[0]);
        int len = startEnd.length;
        for(int i =0;i<len;i++) queue.offer(startEnd[i]);
        int[] temp = queue.poll();
        int last = temp[1];

        while (!queue.isEmpty()){
            int[] top = queue.poll();
            int start = top[0],end = top[1];
            if(start<last) ret++;
            last = Math.min(end,last);
        }

        return ret;

    }
}
