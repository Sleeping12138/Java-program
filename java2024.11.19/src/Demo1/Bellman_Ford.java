package Demo1;

import java.util.Arrays;

class Edge {
    public int a, b, w;

    public Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }
}

public class Bellman_Ford {
    public static int n, m;
    public static final int N = 100010;
    public static int[] path = new int[N];

    public static Edge[] edges = new Edge[N];

    public static int Bellman_Ford() {
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

        for(Edge edge : edges){
            int a = edge.a, b = edge.b, w = edge.w;
            if (path[a] != Integer.MAX_VALUE && path[b] > path[a] + w) {
                System.out.println("存在负环...");
                return -1;
            }
        }

        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }

    public static void main(String[] args) {

    }
}
