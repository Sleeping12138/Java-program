package Demo1;

import java.util.Arrays;

public class Dijkstra {
    public static final int N = 510;
    // 邻接矩阵
    public static int[][] graph = new int[N][N];
    public static int[] path = new int[N];
    public static boolean[] vis = new boolean[N];
    public static int n;

    public static void main(String[] args) {


    }

    // 朴素的dijkstra算法
    public static int dijkstra() {
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;
        for (int i = 0; i < n; i++) {
            int index = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (index == -1 || path[j] < path[index])) index = j;
            }

            if (index == -1) break;
            vis[index] = true;
            for (int j = 1; j <= n; j++) {
                if (graph[index][j] != Integer.MAX_VALUE) {
                    path[j] = Math.max(path[j], path[index] + graph[index][j]);
                }
            }
        }
        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }
}
