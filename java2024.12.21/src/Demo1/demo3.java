package Demo1;

import java.util.Arrays;

public class demo3 {
    public boolean[] vis;
    public int m;
    public boolean flag;

    public int minmumNumberOfHost(int n, int[][] startEnd) {
        m = n;
        vis = new boolean[n];
        dfs(0, 0, startEnd);
        return 0;
    }

    private void dfs(int number, int time, int[][] startEnd) {
        if(number == m) {
            flag = true;
            return;
        }

        for (int i = 0; i < m; i++) {
            int start = startEnd[i][0], end = startEnd[i][1];
            if(vis[i]||start<time) continue;

            vis[i] = true;
            dfs(number+1,end,startEnd);
            if(flag) return;

            vis[i] = false;
        }
    }
}
