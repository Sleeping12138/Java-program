package Demo1;

import java.util.Scanner;

public class demo4 {
    public static int[][] graph;
    public static int n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        int k = in.nextInt();
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
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
            if(graph[x][y]==Integer.MAX_VALUE) System.out.println("");
            else System.out.println(graph[x][y]);
        }
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k]!=Integer.MAX_VALUE&&graph[k][j]!=Integer.MAX_VALUE){
                        graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                    }
                }
            }
        }
    }
}
