package Demo1;

import java.util.Arrays;

public class Prim2 {
    public int n;
    public int[][] graph;
    public int[] dist;
    public boolean[] vis;

    public int Prim() {
        dist = new int[n];
        vis = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int ret = 0;

        // 加点法
        for (int i = 0; i < n; i++) {
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (index == -1 || dist[j] < dist[index])) {
                    index = j;
                }
            }

            if (i > 0 && dist[index] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (i > 0) ret += dist[index];

            vis[index] = true;

            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], graph[index][j]);
            }
        }

        return ret;
    }
}
