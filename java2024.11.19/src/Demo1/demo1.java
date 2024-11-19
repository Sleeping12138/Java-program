//package Demo1;
//
//import java.util.*;
//
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
//        return this.weight - o.weight;
//    }
//}
//
//public class demo1 {
//    public static int n, m;
//    public static final int N = 150010;
//    public static Map<Integer, ArrayList<Pair>> map = new HashMap<>();
//    public static int[] path = new int[N];
//    public static boolean[] vis = new boolean[N];
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        m = in.nextInt();
//        for (int i = 1; i <= n; i++) {
//            map.put(i, new ArrayList<Pair>());
//        }
//        for (int i = 0; i < m; i++) {
//            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
//            boolean flag = true;
//            for (int j = 0; j < map.get(x).size(); j++) {
//                Pair temp = map.get(x).get(j);
//                if (temp.node == y) {
//                    temp.weight = Math.min(temp.weight, z);
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                map.get(x).add(new Pair(y, z));
//            }
//        }
//
//        int ret = dijkstra();
//        System.out.println(ret);
//
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
//            if (vis[node]) continue;
//
//            vis[node] = true;
//
//            for (Pair next : map.get(node)) {
//                if (path[node] != Integer.MAX_VALUE&&path[node] + next.weight < path[next.node]) {
//                    path[next.node] = path[node] + next.weight;
//                    queue.offer(new Pair(next.node, path[next.node]));
//                }
//            }
//        }
//
//        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
//    }
//}
