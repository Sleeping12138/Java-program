package Demo1;

import java.util.Arrays;

//public static int Prim() {
//    Arrays.fill(dist, Integer.MAX_VALUE); // 初始化dist数组
//    dist[1] = 0; // 从节点1开始
//    int ret = 0;
//
//    // 加点法
//    for (int i = 1; i <= n; i++) {
//        int index = -1;
//        // 找到距离生成树最近的点
//        for (int j = 1; j <= n; j++) {
//            if (!vis[j] && (index == -1 || dist[j] < dist[index])) {
//                index = j;
//            }
//        }
//
//        // 如果没有可以连接的点，图不连通，返回impossible
//        if (dist[index] == Integer.MAX_VALUE) {
//            return Integer.MAX_VALUE;
//        }
//
//        // 累加边的权重
//        ret += dist[index];
//        vis[index] = true; // 将当前点加入生成树
//
//        // 更新所有未加入生成树点的最短距离
//        for (int j = 1; j <= n; j++) {
//            if (!vis[j] && graph[index][j] != Integer.MAX_VALUE) {
//                dist[j] = Math.min(dist[j], graph[index][j]);
//            }
//        }
//    }
//
//    return ret;
//}
