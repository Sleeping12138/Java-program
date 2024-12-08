package Demo1;

import java.util.*;

public class demo1 {
    public static int n, m;
    public static Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    public static int[] path;
    public static boolean[] vis;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        path = new int[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) map.put(i, new HashMap<>());
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            map.get(x).put(y, Math.max(map.get(x).getOrDefault(y, Integer.MAX_VALUE), z));
        }

        int ret = spfa();
        System.out.println(ret == Integer.MAX_VALUE ? "impossible" : ret);
    }

    private static int spfa() {
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        vis[1] = true;

        while (!queue.isEmpty()) {
            int top = queue.poll();
            vis[top] = false;

            for (Map.Entry<Integer, Integer> entry : map.get(top).entrySet()) {
                int next = entry.getKey(), weight = entry.getValue();
                if (weight + path[top] < path[next]) {
                    path[next] = weight + path[top];
                    if (!vis[next]) {
                        queue.offer(next);
                        vis[next] = true;
                    }
                }
            }
        }

        return path[n] == Integer.MAX_VALUE ? Integer.MAX_VALUE : path[n];
    }
}
