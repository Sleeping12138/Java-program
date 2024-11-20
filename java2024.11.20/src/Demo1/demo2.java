package Demo1;

import java.util.Arrays;

public class demo2 {
//    public static int dijkstra() {
//        Arrays.fill(path, Integer.MAX_VALUE);
//        path[1] = 0;
//        for (int i = 0; i < n; i++) {
//            int index = -1;
//            for (int j = 1; j <= n; j++) {
//                if (!vis[j] && (index == -1 || path[j] < path[index])) index = j;
//            }
//
//            if (index==-1||path[index]==Integer.MAX_VALUE) break;
//            vis[index] = true;
//            for (int j = 1; j <= n; j++) {
//                if (graph[index][j] != Integer.MAX_VALUE) {
//                    path[j] = Math.min(path[j], path[index] + graph[index][j]);
//                }
//            }
//        }
//
//        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
//    }

//    public static int dijkstra() {
//        Arrays.fill(path, Integer.MAX_VALUE);
//        path[1] = 0;
//
//        PriorityQueue<Pair> queue = new PriorityQueue<>();
//        queue.offer(new Pair(1, 0));
//
//        while (!queue.isEmpty()) {
//            Pair top = queue.poll();
//            int weight = top.weight, node = top.node;
//
//            if (vis[node]||path[node]==Integer.MAX_VALUE) continue;
//
//            vis[node] = true;
//
//            for (Map.Entry<Integer, Integer> entry : map.get(node).entrySet()) {
//                int nextNode = entry.getKey(), nextWeight = entry.getValue();
//                if (path[node] + nextWeight < path[nextNode]) {
//                    path[nextNode] = path[node] + nextWeight;
//                    queue.offer(new Pair(nextNode, path[nextNode]));
//                }
//            }
//        }
//
//        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
//    }
}
