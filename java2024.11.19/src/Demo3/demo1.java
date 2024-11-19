package Demo3;

import java.util.*;

// SPFA算法
public class demo1 {
    public static int n, m;

    public static final int N = 510;
    public static Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    public static int[] path = new int[N];
    public static boolean[] vis = new boolean[N];

    public static int spfa() {
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        vis[1] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            vis[temp] = false;

            if (map.containsKey(temp)) {
                for (Map.Entry<Integer, Integer> entry : map.get(temp).entrySet()) {
                    int node = entry.getKey(), weight = entry.getValue();
                    if (path[node] > path[temp] + weight) {
                        path[node] = path[temp] + weight;
                        if (!vis[node]) {
                            queue.offer(node);
                            vis[node] = true;
                        }
                    }
                }
            }

        }
        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }

    public static void main(String[] args) {

    }
}
