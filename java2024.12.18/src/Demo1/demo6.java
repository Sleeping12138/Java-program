package Demo1;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class demo6 {
    static int N = 510;
    static int n; // 总点数
    static Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>(); // 存储图的邻接表
    static int[] path = new int[N]; // 存储每个点到1号点的最短距离
    static boolean[] vis = new boolean[N]; // 存储每个点是否在队列中

    // SPFA 算法
    public static int spfa() {
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
                if (path[next] > path[top] + weight) {
                    path[next] = path[top] + weight;
                    if (!vis[next]) {
                        queue.offer(next);
                        vis[next] = true;
                    }
                }
            }

        }
        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }

    public static void main(String[] args) {
        // 示例用法
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 总点数
        int m = scanner.nextInt(); // 边的数量

        // 初始化图
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());  // 初始化每个节点的邻接表
        }

        // 输入边的信息并更新邻接表
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int w = scanner.nextInt();
            map.get(a).put(b, w);  // 记录从节点 a 到节点 b 的边，权重为 w
        }

        // 调用 spfa 算法计算从 1 到 n 的最短路径
        int result = spfa();
        System.out.println(result == -1 ? "impossible" : result);
    }
}

