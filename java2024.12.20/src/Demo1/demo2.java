package Demo1;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        HashMap<int[], Integer> map = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            for (int j = 0; j < N; j++) {
                int t = in.nextInt(), d = in.nextInt(), l = in.nextInt();
                int[] temp = new int[]{t, d};
                queue.offer(temp);
                map.put(temp, l);
            }

            int[] head = queue.poll();
            int time = head[0] + map.get(head);
            while (!queue.isEmpty()) {
                int[] top = queue.poll();
                int start = top[0], end = top[1], len = map.get(top);
                if(time<start) time = start;
                if(time>=start&&time<=end){
                    time+=len;
                }else{
                    System.out.println("NO");
                }
            }
            System.out.println("YES");
        }
    }
}
