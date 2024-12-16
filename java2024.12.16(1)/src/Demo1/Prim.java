package Demo1;

import java.util.Arrays;

public class Prim {
    public static int n, m;
    public static int[][] graph;
    public static int[] dist;
    public static boolean[] vis;

    public int Prim() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        int ret = 0;

        for (int i = 0; i < n; i++) {
            int index = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (index == -1 || dist[j] < dist[index])) {
                    index = j;
                }
            }

            if (dist[index] == Integer.MAX_VALUE) return Integer.MAX_VALUE;

            vis[index] = true;

            ret += dist[index];

            for (int j = 1; j <= n; j++) {
                if (!vis[j] && graph[index][j] != Integer.MAX_VALUE) {
                    dist[j] = Math.min(dist[j], graph[index][j]);
                }
            }
        }
        return ret;
    }
}
