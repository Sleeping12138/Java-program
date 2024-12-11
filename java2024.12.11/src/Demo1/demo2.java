package Demo1;

class UnionFind {
    private int[] fa; // 父节点数组
    private int groups; // 连通分量个数

    // 构造函数，初始化并查集
    public UnionFind(int n) {
        fa = new int[n]; // 注意：这里不加1，数组从0到n-1
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        groups = n;
    }

    // 非递归版本的 Find 方法
    public int find(int x) {
        int root = x;
        // 找到根节点
        while (fa[root] != root) {
            root = fa[root];
        }
        // 路径压缩
        while (fa[x] != root) {
            int temp = fa[x];
            fa[x] = root;
            x = temp;
        }
        return root;
    }

    // 递归版本的 Find 方法
    public int findR(int x) {
        if (fa[x] != x) {
            fa[x] = findR(fa[x]); // 路径压缩
        }
        return fa[x];
    }

    // 合并两个节点所在的集合
    // 返回新根节点，如果没有发生合并，则返回 -1
    public int merge(int from, int to) {
        int x = find(from);
        int y = find(to);
        if (x == y) {
            return -1; // 已经在同一个集合中
        }
        fa[x] = y; // 将 x 的根节点指向 y
        groups--; // 连通分量减少
        return y;
    }

    // 判断两个节点是否在同一个集合中
    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    // 获取连通分量的数量
    public int getGroups() {
        return groups;
    }
}


public class demo2 {
    public static void main(String[] args) {

    }
}