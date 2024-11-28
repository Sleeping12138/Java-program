package Demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class demo3 {
    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static int[] happy;
    public static int[] f;
    public static int[] g;
    public static boolean[] vis;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        happy = new int[n+1];
        f = new int[n+1];
        g = new int[n+1];
        vis = new boolean[n+1];

        for(int i = 1;i<=n;i++){
            happy[i] = in.nextInt();
        }
        for(int i = 0;i<n-1;i++){
            int L = in.nextInt(),K = in.nextInt();
            if(!map.containsKey(K)) map.put(K,new ArrayList<>());
            map.get(K).add(L);
            vis[L] = true;
        }

        int root = 0;
        for(int i = 1;i<n+1;i++){
            if(!vis[i]){
                root = i;
                break;
            }
        }

        dfs(root);
        System.out.println(Math.max(f[root],g[root]));
    }
    public static void dfs(int root){
        if (map.get(root) == null) {
            g[root]+=happy[root];
            return;
        }

        for(int next : map.get(root)){
            dfs(next);
            f[root] += Math.max(f[next],g[next]);
            g[root] += f[next];
        }
        g[root]+=happy[root];
    }
}
