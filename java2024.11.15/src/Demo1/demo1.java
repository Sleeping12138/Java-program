package Demo1;

import java.util.*;

public class demo1 {
    public static final int N = 110;
    public static int n, m;
    public static int[][] map = new int[N][N];
    public static int[][] pathLen = new int[N][N];
    public static boolean[][] visited = new boolean[N][N]; // 使用访问标记数组

    // 四个方向的移动，分别是上、下、左、右
    public static int[] x = {0, 0, -1, 1};
    public static int[] y = {1, -1, 0, 0};

    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        // 输入地图数据
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        // 初始化起点
        queue.offer(new int[]{1, 1});
        visited[1][1] = true;
        pathLen[1][1] = 0;

        // 执行广度优先搜索
        bfs();

        // 输出最短路径长度
        System.out.println(pathLen[n][m]);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x1 = temp[0], y1 = temp[1];

            // 遍历四个方向
            for (int i = 0; i < 4; i++) {
                int newX = x1 + x[i], newY = y1 + y[i];

                // 判断新位置是否合法，并且没有被访问过
                if (newX >= 1 && newX <= n && newY >= 1 && newY <= m && !visited[newX][newY] && map[newX][newY] == 0) {
                    // 标记为已访问
                    visited[newX][newY] = true;

                    // 更新路径长度
                    pathLen[newX][newY] = pathLen[x1][y1] + 1;

                    // 将新位置加入队列
                    queue.offer(new int[]{newX, newY});

                    // 如果到达目标位置，提前结束
                    if (newX == n && newY == m) {
                        return;
                    }
                }
            }
        }
    }
}

