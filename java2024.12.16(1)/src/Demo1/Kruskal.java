package Demo1;

import java.util.Arrays;

class Kruskal {
    int n, m;  // n是点数，m是边数
    int[] parent;   // 并查集的父节点数组
    Edge[] edges; // 存储边

    static class Edge implements Comparable<Edge> {
        int a, b, w;

        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    public int find(int x) {
        if (parent[x] < 0) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public int kruskal() {
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

