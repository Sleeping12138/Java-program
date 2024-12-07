package Demo1;

import java.util.*;

class Pair implements Comparable<Pair> {
    public int node;
    public int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class demo2 {
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
        for (int i = 0; i < n; i++) map.put(i, new HashMap<>());
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            map.get(x).put(y, Math.min(map.get(x).getOrDefault(y, Integer.MAX_VALUE), z));
        }

        int ret = dijkstra();
        System.out.println(ret);
    }

    private static int dijkstra() {
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(1, 0));

        while (!queue.isEmpty()) {
            Pair top = queue.poll();
            int node = top.node, weight = top.weight;

            if (vis[node]) continue;

            vis[node] = true;

            if (map.get(node) != null) {
                for (Map.Entry<Integer, Integer> entry : map.get(node).entrySet()) {
                    int next = entry.getKey(), nextWeight = entry.getValue();
                    if (path[next] > path[node] + nextWeight) {
                        path[next] = path[node] + nextWeight;
                        queue.offer(new Pair(next, path[next]));
                    }
                }
            }

        }

        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }
}
