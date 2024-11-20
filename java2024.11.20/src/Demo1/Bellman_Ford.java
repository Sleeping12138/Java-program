package Demo1;

import java.util.Arrays;
import java.util.Scanner;

public class Bellman_Ford {
    public static int N = 510;
    public static int n, m;
    public static int[] path = new int[N];

    public static Edge[] edges;

    public static class Edge {
        int a, b, w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            edges[i] = new Edge(x, y, z);
        }

        System.out.println(bellman_Ford());
    }

    private static int bellman_Ford() {
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int a = edge.a, b = edge.b, w = edge.w;
                if (path[a] != Integer.MAX_VALUE && path[b] > path[a] + w) {
                    path[b] = path[a] + w;
                }
            }
        }

        for (Edge edge : edges) {
            int a = edge.a, b = edge.b, w = edge.w;
            if (path[a] != Integer.MAX_VALUE && path[b] > path[a] + w) {
                System.out.println("存在负环...");
            }
        }

        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }
}
