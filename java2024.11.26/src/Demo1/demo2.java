package Demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class demo2 {
    public static final int N = 6010;
    public static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static boolean[] flag = new boolean[N];
    public static int[] happy = new int[N];
    public static int[] f = new int[N];
    public static int[] g = new int[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i <= n; i++) happy[i] = in.nextInt();


        for (int i = 0; i < n - 1; i++) {
            int L = in.nextInt();
            int K = in.nextInt();
            flag[L] = true;
            if (!map.containsKey(K)) map.put(K, new ArrayList<>());
            map.get(K).add(L);
        }

        int root = 1;
        for (int i = 1; i <= n; i++) {
            if (!flag[i]) {
                root = i;
                break;
            }
        }

        dfs(root);

        System.out.println(Math.max(f[root], g[root]));
    }

    public static void dfs(int root) {
        ArrayList<Integer> list = map.get(root);
        if (list == null) {
            g[root] = happy[root];
            return;
        }

        for (int next : list) {
            dfs(next);
            f[root] += Math.max(f[next], g[next]);
            g[root] += f[next];
        }

        g[root] += happy[root];
    }
}
