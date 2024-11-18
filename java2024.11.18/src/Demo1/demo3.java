package Demo1;

import java.util.*;

// 堆优化版本的dijkstra算法 - 优化在取出路径最短的节点
class Pair implements Comparable<Pair> {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        return this.weight - o.weight;
    }
}

public class demo3 {
    public static int N = 510;
    public static int n, m;
    public static Map<Integer, ArrayList<Pair>> map = new HashMap<>();
    public static int[] path = new int[N];
    public static boolean[] vis = new boolean[N];

    public int dijkstra() {
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(1, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            int next = temp.node, weight = temp.weight;

            if (vis[next]) continue;

            vis[next] = true;

            for (Pair target : map.get(next)) {
                if (target.weight + weight < path[target.node]) {
                    path[target.node] = target.weight + weight;
                    queue.offer(new Pair(target.node, target.weight));
                }
            }
        }

        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }

    public static void main(String[] args) {

    }
}
