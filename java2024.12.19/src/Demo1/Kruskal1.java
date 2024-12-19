package Demo1;

import java.util.Arrays;

public class Kruskal1 {
    public int n, m;
    // 使用并查集的思想进行元素的合并
    public int[] parent;
    public Edge[] edges;

    static class Edge implements Comparable<Edge> {
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

    // 找根节点，判断是否是同一个集合
    public int find(int x) {
        if (parent[x] < 0) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public int Kruskal() {
        // 排序
        Arrays.sort(edges);
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        // 枚举每条边，如果两点不在同一个集合则连接
        int ret = 0, count = 0;
        for (Edge e : edges) {
            int a = e.a, b = e.b, w = e.w;
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