package Demo1;

import java.util.*;

public class demo7 {
    public static int[][] graph;
    public static int n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            graph[x][y] = Math.min(graph[x][y], z);
        }

        floyd();

        for (int i = 0; i < k; i++) {
            int x = in.nextInt(), y = in.nextInt();
            if (graph[x][y] == Integer.MAX_VALUE) System.out.println("impossible");
            else System.out.println(graph[x][y]);
        }
    }

    // Floyd算法
    private static void floyd() {
        // 通过中间节点进行最短路径优化
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
    }
}
