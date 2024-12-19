package Demo1;

import java.util.Arrays;

public class Prim {
    public static int n, m;
    public static int[][] graph;
    public static int[] path;
    public static boolean[] vis;

    public static void main(String[] args) {

    }

    public static int Prim() {
        // 初始化
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;
        int ret = 0;

        // 找到最小生成树路径最短的节点
        int index = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (index == -1 || path[j] < path[index])) {
                    index = j;
                }
            }
        }

        if (path[index] == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        vis[index] = true;
        ret += path[index];

        // 通过该节点对未加入到最小生成树中的节点进行更新
        for (int j = 1; j <= n; j++) {
            if (!vis[j] && graph[index][j] != Integer.MAX_VALUE) {
                path[j] = Math.min(path[j], path[index] + graph[index][j]);
            }
        }
        return ret;
    }
}
