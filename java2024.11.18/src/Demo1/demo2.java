package Demo1;

import java.util.Arrays;
import java.util.Scanner;

public class demo2 {
    public static int n, m;
    public static int N = 510;
    public static int[][] graph = new int[N][N];
    public static int[] path = new int[N];
    public static boolean[] vis = new boolean[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            graph[x][y] = Math.min(graph[x][y], z);
        }

        int ret = dijkstra();
        System.out.println(ret);
    }

    private static int dijkstra() {
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
                    path[j] = Math.min(path[j], path[index] + graph[index][j]);
                }
            }
        }

        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }
}
