package Demo1;

import java.util.Arrays;
import java.util.Scanner;

public class demo1 {
    public static int n, m;
    public static int[] path;
    public static boolean[] vis;

    public static int[][] graph;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        path = new int[n + 1];
        vis = new boolean[n + 1];
        graph = new int[n + 1][n + 1];
        for(int i =0;i<n+1;i++){
            Arrays.fill(graph[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            graph[x][y] = Math.min(graph[x][y], z);
        }

        int ret = dijkstra();
        System.out.println(ret);
    }

    private static int dijkstra() {
        // 初始化
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        for (int i = 0; i < n; i++) {
            int index = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (index == -1 || path[j] < path[index])) index = j;
            }

            if (path[index] == Integer.MAX_VALUE || index == -1) break;

            vis[index] = true;

            for (int j = 1; j <= n; j++) {
                if (graph[index][j] != Integer.MAX_VALUE) {
                    path[j] = Math.min(path[j], path[index] + graph[index][j]);
                }
            }

        }
        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }
}
