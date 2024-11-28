package Demo1;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class demo5 {
    public static int[][] path;
    public static boolean[][] vis;
    public static int[] x = {0, 0, -1, 1};
    public static int[] y = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt(), m = in.nextInt();
            int x0 = 0, y0 = 0;
            int minPath = Integer.MAX_VALUE;
            int number = 0;
            char[][] chs = new char[n][m];
            path = new int[n][m];
            vis = new boolean[n][m];
            for (int i = 0; i < n; i++) chs[i] = in.next().toCharArray();
            for (int i = 0; i < n; i++) {
                boolean flag = false;
                for (int j = 0; j < m; j++) {
                    if (chs[i][j] == 'k') {
                        x0 = i;
                        y0 = j;
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x0, y0});
            vis[x0][y0] = true;
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = temp[0] + x[i], newY = temp[1] + y[i];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && !vis[newX][newY] && chs[newX][newY] != '*') {
                        path[newX][newY] = path[temp[0]][temp[1]] + 1;
                        if (chs[newX][newY] == 'e') {
                            number++;
                            minPath = Math.min(minPath, path[newX][newY]);
                        }
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }

            if (number != 0) System.out.println(number + " " + minPath);
            else System.out.println(-1);
        }
    }
}
