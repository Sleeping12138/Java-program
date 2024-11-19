package Demo3;


import java.util.*;

public class demo2 {
    public static int N = 100010;
    public static int n, m; // 总点数
    public static Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>(); // 存储图的邻接表
    public static int[] path = new int[N]; // 存储每个点到1号点的最短距离
    public static boolean[] vis = new boolean[N]; // 存储每个点是否在队列中

    // SPFA 算法
    public static int spfa() {
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;  // 设定起点 1 的距离为 0

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);  // 将起点 1 放入队列
        vis[1] = true;  // 标记起点已在队列中

        while (!queue.isEmpty()) {
            int t = queue.poll();  // 从队列中取出一个节点
            vis[t] = false;  // 标记节点不再在队列中

            // 遍历所有邻接边
            if (map.containsKey(t)) {
                for (Map.Entry<Integer, Integer> entry : map.get(t).entrySet()) {
                    int j = entry.getKey();  // 邻接节点
                    int w = entry.getValue();  // 边的权重

                    // 如果通过当前节点 t 可以更新邻接节点 j 的最短路径
                    if (path[j] > path[t] + w) {
                        path[j] = path[t] + w;

                        // 如果邻接节点 j 不在队列中，则加入队列
                        if (!vis[j]) {
                            queue.add(j);
                            vis[j] = true;
                        }
                    }
                }
            }
        }

        return path[n] == Integer.MAX_VALUE ? Integer.MAX_VALUE : path[n];  // 返回目标节点的最短路径，若不可达返回 -1
    }

    public static void main(String[] args) {
        // 示例用法
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 总点数
        m = scanner.nextInt(); // 边的数量

        // 初始化图
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());  // 初始化每个节点的邻接表
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int w = scanner.nextInt();

            // 处理重边：只保留权重最小的边
            if (!map.get(a).containsKey(b) || map.get(a).get(b) > w) {
                map.get(a).put(b, w);
            }
        }

        // 调用 spfa 算法计算从 1 到 n 的最短路径
        int result = spfa();
        System.out.println(result == Integer.MAX_VALUE ? "impossible" : result);
    }
}
