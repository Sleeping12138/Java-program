package Demo1;

import java.util.Arrays;
import java.util.Scanner;


public class demo3 {
    public static final int N = 510;
    public static int n, m;
    public static int[][] graph = new int[N][N];
    public static int[] path = new int[N];
    public static boolean[] vis = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < N; i++) Arrays.fill(graph, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            graph[x][y] = Math.min(graph[x][y], z);
        }

        int ret = dijkstra();
        System.out.println(ret);
    }

    private static int dijkstra() {
        // 对存储最短路径的数组进行初始化
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        // 每次确定一个最短路径
        for (int i = 0; i < n; i++) {
            // 找没有确定最短路径并且路径最短的节点
            int index = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (index == -1 || path[j] < path[index])) index = j;
            }

            // 没有满足条件的
            if (index == -1 || path[index] == Integer.MAX_VALUE) break;

            vis[index] = true;

            // 使用该点去跟新其他点的最短路径
            for (int j = 1; j <= n; j++) {
                if (graph[index][j] != Integer.MAX_VALUE) {
                    path[j] = Math.min(path[j], path[index] + graph[index][j]);
                }
            }
        }

        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }
}
