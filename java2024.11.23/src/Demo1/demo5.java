package Demo1;
import java.util.*;

public class demo5 {
    public static final int N = 100;  // 最大点数，假设最多有100个点
    public static final int INF = Integer.MAX_VALUE;  // 无穷大，用来表示不可达

    public static int n, m;  // n为点数，m为边数
    public static int[][] d = new int[N][N];  // 存储最短路径的二维数组

    // Floyd-Warshall 算法
    public static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 更新最短路径
                    if (d[i][k] != INF && d[k][j] != INF) {  // 防止溢出
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();  // 输入点数
        m = scanner.nextInt();  // 输入边数

        // 初始化图，所有的点到其他点的最短距离为无穷大，自己到自己的距离为0
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }

        // 输入边的信息并更新邻接矩阵
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();  // 起点
            int b = scanner.nextInt();  // 终点
            int w = scanner.nextInt();  // 边的权重
            d[a][b] = Math.min(d[a][b], w);  // 如果有多条边，取最小的权重
        }

        // 调用 Floyd-Warshall 算法
        floyd();

        // 输出结果，d[i][j]表示从i到j的最短距离
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (d[i][j] == INF) {
                    System.out.print("INF ");  // 不可达
                } else {
                    System.out.print(d[i][j] + " ");  // 输出最短距离
                }
            }
            System.out.println();  // 换行
        }
    }
}

