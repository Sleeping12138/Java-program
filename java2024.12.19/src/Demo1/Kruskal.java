package Demo1;

import java.util.Arrays;

public class Kruskal {
    public int n, m;
    public int[] parent;
    public Edge[] edges;

    public static class Edge implements Comparable<Edge> {
        public int a, b, w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public int find(int x) {
        if (parent[x] < 0) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public int Kruskal() {
        Arrays.sort(edges);
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        int ret = 0, count = 0;

        for (Edge edge : edges) {
            int a = edge.a, b = edge.b, w = edge.w;
            a = find(a);
            b = find(b);
            if (a != b) {
                parent[a] = b;
                ret += w;
                count++;
            }
        }

        return count < n - 1 ? -1 : ret;
    }
}
