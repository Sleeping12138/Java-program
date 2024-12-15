package Demo1;

import java.util.Arrays;
public class Prim {
    static final int INF = Integer.MAX_VALUE;
    int n;      // n表示点数
    int[][] g;  // 邻接矩阵，存储所有边
    int[] dist; // 存储其他点到当前最小生成树的距离
    boolean[] st; // 存储每个点是否已经在生成树中

    public int prim() {
        dist = new int[n];
        st = new boolean[n];

        Arrays.fill(dist, INF);

        int res = 0;

        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }

            if (i > 0 && dist[t] == INF) {
                return INF;
            }

            if (i > 0) {
                res += dist[t];
            }

            st[t] = true;

            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }
        }
        return res;
    }

}

