package Demo1;

import java.util.*;

public class demo5 {
    public static int n, m; // n表示点数，m表示边数
    public static final int N = 100010; // 设置点的最大范围
    public static int[] path = new int[N]; // path[x]用于存储 1 到 x 的最短路距离

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
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge e : edges) {
                int a = e.a, b = e.b, w = e.w;
                if (path[a] != Integer.MAX_VALUE && path[b] > path[a] + w) {
                    path[b] = path[a] + w;
                }
            }
        }

        for (Edge e : edges) {
            int a = e.a, b = e.b, w = e.w;
            if (path[a] != Integer.MAX_VALUE && path[b] > path[a] + w) {
                System.out.println("存在负环...");
                return -1;
            }
        }

        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }
}


