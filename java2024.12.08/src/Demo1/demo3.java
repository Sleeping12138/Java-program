package Demo1;
import java.util.Scanner;

public class demo3 {
    public static int n, m;
    public static final int N = 210;
    public static int[][] graph = new int[N][N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 初始化的时候，主对角线上的距离必须为0
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            graph[x][y] = Math.min(graph[x][y], z);
        }

        floyd();

        for(int i = 0;i<k;i++){
            int x = in.nextInt(),y = in.nextInt();
            if(graph[x][y]==Integer.MAX_VALUE){
                System.out.println("impossible");
            }else{
                System.out.println(graph[x][y]);
            }
        }
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    if(graph[i][k]!=Integer.MAX_VALUE&&graph[k][j]!=Integer.MAX_VALUE){
                        graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                    }
                }
            }
        }
    }
}
