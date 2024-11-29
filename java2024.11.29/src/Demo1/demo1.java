package Demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class demo1 {
    public static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static int[] f;
    public static int[] g;
    public static boolean[] vis;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        f = new int[n];
        g = new int[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int index = in.nextInt(), k = in.nextInt();
            for (int j = 0; j < k; j++) {
                int next = in.nextInt();
                map.get(index).add(next);
                map.get(next).add(index);
            }
        }

        dfs(0);
        System.out.println(Math.min(f[0], g[0]));
    }

    public static void dfs(int root) {
        vis[root] = true;
        g[root] += 1;
        if (map.get(root).isEmpty()) return;

        for (int next : map.get(root)) {
            if (!vis[next]) {
                dfs(next);
                f[root] += g[next];
                g[root] += Math.min(f[next], g[next]);
            }
        }
    }
}
