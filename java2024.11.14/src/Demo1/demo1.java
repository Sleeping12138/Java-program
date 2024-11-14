package Demo1;

import java.util.*;

public class demo1 {
    public static int n;
    public static char[][] board;
    public static boolean[] vis, dg, udg;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new char[n][n];
        vis = new boolean[n];
        dg = new boolean[2 * n];
        udg = new boolean[2 * n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(0);
    }

    public static void dfs(int r) {
        if (r == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
        
        for (int i = 0; i < n; i++) {
            if (!vis[i] && !dg[n + i - r] && !udg[i + r]) {
                board[r][i] = 'Q';
                vis[i] = dg[n + i - r] = udg[i + r] = true;
                dfs(r + 1);
                board[r][i] = '.';
                vis[i] = dg[n + i - r] = udg[i + r] = false;
            }
        }
    }
}
