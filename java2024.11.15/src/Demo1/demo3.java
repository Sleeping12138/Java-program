package Demo1;

import java.util.*;

public class demo3 {
    public static int n;
    public static Map<Integer, List<Integer>> map = new HashMap<>();
    public static int[] size;  // size[i] 表示节点 i 的子树大小
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        // 初始化树的邻接表
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        // 读取树的边
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map.get(a).add(b);
            map.get(b).add(a);
        }

        size = new int[n + 1];
        visited = new boolean[n + 1];

        // 从节点 1 开始 DFS 计算子树大小
        dfs(1);

        int bestMax = Integer.MAX_VALUE;  // 最小化的最大值

        // 计算每个节点作为重心时的最大连通块大小
        for (int i = 1; i <= n; i++) {
            bestMax = Math.min(bestMax, getMaxBlockSize(i));
        }

        // 输出结果
        System.out.println(bestMax);
    }

    // DFS计算每个子树的大小
    public static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : map.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
                size[node] += size[neighbor];  // 将子树的大小加到当前节点
            }
        }
        size[node]++;
    }

    // 计算删除节点 u 后，剩余各个连通块中点数的最大值
    public static int getMaxBlockSize(int u) {
        int maxBlockSize = 0;

        // 遍历节点 u 的所有邻居
        for (int neighbor : map.get(u)) {
            // 删除节点 u 后，剩余的块是该子树或树的其余部分
            if (size[neighbor] < size[u]) {  // 只考虑子树部分
                maxBlockSize = Math.max(maxBlockSize, size[neighbor]);
            }
        }

        // 计算删除节点 u 后的其它部分的大小（即树的剩余部分）
        maxBlockSize = Math.max(maxBlockSize, n - size[u]);

        return maxBlockSize;
    }
}

