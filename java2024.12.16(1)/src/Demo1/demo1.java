package Demo1;

import java.util.Arrays;

public class demo1 {
//    public static int Prim() {
//        // 初始化所有点到最小生成树的初始距离为Integer.MAX_VALUE
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[1] = 0;
//        int ret = 0;
//
//        // 加点法，每次向最小生成树中加入一个点
//        for (int i = 0; i < n; i++) {
//            int index = -1;
//            for (int j = 1; j <= n; j++) {
//                if (!vis[j] && (index == -1 || dist[j] < dist[index])) {
//                    index = j;
//                }
//            }
//
//            // 无连通则退出
//            if (dist[index] == Integer.MAX_VALUE) {
//                return Integer.MAX_VALUE;
//            }
//
//            ret += dist[index];
//
//            // 将点加入到最小生成树中
//            vis[index] = true;
//
//            // 更新其他点
//            for (int j = 1; j <= n; j++) {
//                if (!vis[j] && graph[index][j] != Integer.MAX_VALUE) {
//                    dist[j] = Math.min(dist[j], graph[index][j]);
//                }
//            }
//        }
//
//        return ret;
//    }
    public static void main(String[] args) {

    }
}
