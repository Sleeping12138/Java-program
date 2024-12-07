package Demo1;

import java.util.*;

public class demo4 {
    public static int n, m;
    public static int[] path;
    public static boolean[] vis;
    public static Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        path = new int[n + 1];
        vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) map.put(i, new HashMap<>());

        for (int i = 0; i < m; i++) {
            int a = in.nextInt(), b = in.nextInt(), w = in.nextInt();
            map.get(a).put(b, Math.min(map.get(a).getOrDefault(b, Integer.MAX_VALUE), w));
        }

        int ret = spfa();
        System.out.println(ret==Integer.MAX_VALUE?"impossible":ret);
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

            if (map.get(top) != null) {
                for (Map.Entry<Integer, Integer> entry : map.get(top).entrySet()) {
                    int next = entry.getKey(), weight = entry.getValue();
                    path[next] = Math.min(path[next], path[top] + weight);
                    if (!vis[next]) queue.offer(next);
                }

            }
        }
        return path[n] == Integer.MAX_VALUE ? Integer.MAX_VALUE : path[n];
    }
}
