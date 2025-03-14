package Demo1;

import java.util.*;

public class demo2 {
    public int n, m;
    public int x1, y1, x2, y2;
    public int[][] path = new int[15][15];
    public int[][] num = new int[15][15];
    int[] x = {0, 0, 1, -1};
    int[] y = {1, -1, 0, 0};

    public int countPath(int[][] CityMap, int _n, int _m) {
        n = _n;
        m = _m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                path[i][j] = -1;
                if (CityMap[i][j] == 1) {
                    x1 = i;
                    y1 = j;
                } else if (CityMap[i][j] == 2) {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        path[x1][y1] = 0;
        num[x1][y1] = 1;
        bfs(CityMap);

        return num[x2][y2];
    }

    public void bfs(int[][] CityMap) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x1, y1});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = temp[0] + x[i], newY = temp[1] + y[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && CityMap[newX][newY] != -1) {
                    if (path[newX][newY] == -1) {
                        // 第一次到达这个点
                        path[newX][newY] = path[temp[0]][temp[1]] + 1;
                        num[newX][newY] += num[temp[0]][temp[1]];
                        queue.offer(new int[]{newX, newY});
                    } else if (path[newX][newY] == path[temp[0]][temp[1]] + 1) {
                        // 多条最短路径
                        num[newX][newY] += num[temp[0]][temp[1]];
                    }
                }
            }
        }
    }
}

