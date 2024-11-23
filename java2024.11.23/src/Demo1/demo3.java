package Demo1;

import java.util.*;

public class demo3 {
    public static int n, m; // n表示点数，m表示边数
    public static final int N = 100010; // 设置点的最大范围
    public static int[] dist = new int[N]; // dist[x]用于存储 1 到 x 的最短路距离

    public static Edge[] edges;

    static class Edge {
        int a, b, w;

        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入点和边数
        n = scanner.nextInt();
        m = scanner.nextInt();

        // 创建边数组
        edges = new Edge[m];

        // 输入边信息
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int w = scanner.nextInt();
            edges[i] = new Edge(a, b, w);
        }

        // 调用 Bellman-Ford 算法
        int result = bellmanFord();

        // 输出结果
        System.out.println(result);
    }

    static int bellmanFord() {
        Arrays.fill(dist, Integer.MAX_VALUE); // 初始化所有点的最短路距离为无穷大
        dist[1] = 0; // 起点距离设为 0

        // 重复进行 n-1 轮实现松张操作
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int a = edge.a, b = edge.b, w = edge.w;
                // 如果通过边信息可以更优距离，则更新
                if (dist[a] != Integer.MAX_VALUE && dist[b] > dist[a] + w) {
                    dist[b] = dist[a] + w;
                }
            }
        }

        // 检查是否存在违规圈
        for (Edge edge : edges) {
            int a = edge.a, b = edge.b, w = edge.w;
            if (dist[a] != Integer.MAX_VALUE && dist[b] > dist[a] + w) {
                // 如果发现可以更优，说明存在违规圈
                System.out.println("Negative cycle detected");
                return -1;
            }
        }

        // 如果结点 n 无法达到，返回 -1
        return dist[n] == Integer.MAX_VALUE ? -1 : dist[n];
    }
}

