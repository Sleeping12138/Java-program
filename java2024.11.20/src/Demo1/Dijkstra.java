package Demo1;

import java.util.Arrays;
import java.util.Scanner;

// 朴素的Dijkstra算法 - 使用于稠密图
public class Dijkstra {
    public static final int N = 510;
    public static int n, m;
    public static int[][] graph = new int[N][N];
    public static int[] path = new int[N];
    public static boolean[] vis = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            graph[x][y] = Math.min(graph[x][y], z);
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        // 初始化
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        for (int i = 0; i < n; i++) {
            // 找到没有确定最短路径且路径最短的节点
            int index = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (index == -1 || path[j] < path[index])) {
                    index = j;
                }
            }

            if (index == -1 || path[index] == Integer.MAX_VALUE) break;
            vis[index] = true;

            // 修改其他节点
            for (int j = 1; j <= n; j++) {
                if (graph[index][j] != Integer.MAX_VALUE) {
                    path[j] = Math.min(path[j], path[index] + graph[index][j]);
                }
            }

            return path[n] == Integer.MAX_VALUE ? -1 : path[n];
        }
    }
}
