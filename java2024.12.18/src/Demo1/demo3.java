package Demo1;

import java.util.Arrays;
import java.util.Scanner;

public class demo3 {
    public static int n, m;
    public static int N = 510;

    // 使用邻接矩阵来存储有向图
    public static int[][] graph = new int[N][N];

    // 每个节点到根节点的最短路径长度
    public static int[] path = new int[N];

    // 该节点是否确定了最短路径长度
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
        // 初始化
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        for (int i = 0; i < n; i++) {
            int index = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (index == -1 || path[j] < path[index])) {
                    index = j;
                }
            }

            if (index == -1 || path[index] == Integer.MAX_VALUE) break;

            vis[index] = true;

            for (int j = 1; j <= n; j++) {
                if (graph[index][j] != Integer.MAX_VALUE) {
                    path[j] = Math.min(path[j], graph[index][j] + path[index]);
                }
            }
        }

        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }
}

