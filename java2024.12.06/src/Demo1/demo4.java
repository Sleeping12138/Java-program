//package Demo1;
//
//import java.util.*;
//class Pair implements Comparable<Pair> {
//    int node;
//    int weight;
//
//    public Pair(int node, int weight) {
//        this.node = node;
//        this.weight = weight;
//    }
//
//    @Override
//    public int compareTo(Pair o) {
//        // 比较更安全
//        return Integer.compare(this.weight, o.weight);
//    }
//}
//
//public class demo4 {
//    public static int n, m;
//    public static final int N = 150010;
//    public static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
//    public static int[] path;
//    public static boolean[] vis;
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        m = in.nextInt();
//
//        path = new int[n + 1];
//        vis = new boolean[n+1];
//
//        for(int i = 1;i<=n;i++){
//            map.put(i,new HashMap<>());
//        }
//
//        for (int i = 0; i < m; i++) {
//            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
//            map.get(x).put(y, Math.min(map.get(x).getOrDefault(y, Integer.MAX_VALUE), z));
//        }
//
//        int ret = dijkstra();
//        System.out.println(ret);
//    }
//
//    private static int dijkstra() {
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
//            if (vis[node] || path[node]==Integer.MAX_VALUE) continue;
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
//}
//
//
