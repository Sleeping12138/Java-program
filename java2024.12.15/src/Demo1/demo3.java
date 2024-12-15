package Demo1;

import java.util.*;

public class demo3 {
    public static int n,m;
    public static int[][] graph;
    public static int[] dist;
    public static boolean[] vis;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();m =in.nextInt();
        graph = new int[n][n];
        dist = new int[n];
        vis = new boolean[n];
        for(int i = 0;i<n;i++){
            for(int j= 0;j<n;j++){
                if(i==j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0;i<m;i++){
            int u = in.nextInt(),v = in.nextInt(),w = in.nextInt();
            graph[u][v] = w;
        }

        int ret = Prim();
        System.out.println(ret);

    }

    public static int Prim() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        int ret = 0;

        // 加点法
        for (int i = 0; i < n; i++) {
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (index == -1 || dist[j] < dist[index])) {
                    index = j;
                }
            }

            if (i > 0 && dist[index] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (i > 0) ret += dist[index];

            vis[index] = true;

            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], graph[index][j]);
            }
        }

        return ret;
    }
}

