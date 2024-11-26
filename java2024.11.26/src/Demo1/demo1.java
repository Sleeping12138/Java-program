package Demo1;

import java.util.*;

public class demo1 {
    public static final int N = 6010;
    public static int[] happy = new int[N];
    public static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static int[][] f = new int[N][2];
    public static int n;
    static boolean[] vis = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            happy[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int l = sc.nextInt(); // 子节点
            int k = sc.nextInt(); // 父节点
            vis[l] = true; // 记录 l 节点有父节点
            if(!map.containsKey(k)) map.put(k,new ArrayList<>());
            map.get(k).add(l);
        }

        for (int i = 1; i <= n; i++) {
            f[i][1] = happy[i];
        }

        // 找到树的根节点（没有父节点的节点）
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                root = i;
                break;
            }
        }

        dfs(root);

        System.out.println(Math.max(f[root][0], f[root][1]));
    }

    // 函数表示初始化x节点选择或不选择时所获得的快乐值
    public static void dfs(int x) {
        List<Integer> list = map.get(x);
        if (list == null) return;

        for (int b : list) {
            dfs(b);
            f[x][1] += f[b][0];
            f[x][0] += Math.max(f[b][1], f[b][0]);
        }
    }
}

