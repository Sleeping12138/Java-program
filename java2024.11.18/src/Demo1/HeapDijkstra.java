//package Demo1;
//
//import java.util.*;
//
//// 用于表示边的类 - 使用HashMap无法在优先级队列中进行比较
//class Pair implements Comparable<Pair> {
//    int node;     // 邻接节点的编号
//    int distance; // 边的权重
//
//    Pair(int distance, int node) {
//        this.distance = distance;
//        this.node = node;
//    }
//
//    @Override
//    public int compareTo(Pair other) {
//        return this.distance - other.distance; // 按照边的权重升序排序
//    }
//}
//
//public class HeapDijkstra {
//    public static int n, m;
//    public static int N = 510; // 最大节点数
//    public static Map<Integer, ArrayList<Pair>> map = new HashMap<>(); // 邻接表存储所有边
//    public static int[] dist = new int[N]; // 存储1号点到每个点的最短距离
//    public static boolean[] st = new boolean[N]; // 存储每个点的最短距离是否已确定
//
//    private static int dijkstra() {
//        // 初始化path
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[1] = 0;
//
//        PriorityQueue<Pair> pq = new PriorityQueue<>();
//        pq.add(new Pair(0, 1));
//
//        while (!pq.isEmpty()) {
//            // 1.拿出路径最短的节点
//            Pair p = pq.poll();
//            int node = p.node, distance = p.distance;
//
//            // 判断是否已经确定了最短路径
//            if (st[node]) continue;
//
//            // 2.标记为已确定最短距离
//            st[node] = true;
//
//            // 修改其相邻节点的最短路径
//            for (Pair edge : map.get(node)) {
//                int next = edge.node, weight = edge.distance;
//
//                if (distance + weight < dist[next]) {
//                    dist[next] = distance + weight;
//                    pq.add(new Pair(dist[next], next));
//                }
//            }
//        }
//
//        return dist[n] == Integer.MAX_VALUE ? -1 : dist[n];
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt(); // 读取节点数量
//        m = in.nextInt(); // 读取边的数量
//
//        // 初始化邻接表
//        for (int i = 1; i <= n; i++) {
//            map.put(i, new ArrayList<>());
//        }
//
//        // 输入所有边的信息
//        for (int i = 0; i < m; i++) {
//            int u = in.nextInt(), v = in.nextInt(), w = in.nextInt();
//            map.get(u).add(new Pair(w, v)); // u -> v 边，权重为 w
//            // 如果是无向图，可以加上反向边
//            // map.get(v).add(new Pair(w, u)); // v -> u 边，权重为 w
//        }
//
//        // 求1号点到n号点的最短距离
//        int result = dijkstra();
//        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
//    }
//}
//
