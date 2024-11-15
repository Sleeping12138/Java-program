package Demo1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static final int N = 110;
    public static int n, m;
    public static int[][] map = new int[N][N];
    public static int[][] pathLen = new int[N][N];

    public static int[] x = {0, 0, -1, 1};
    public static int[] y = {1, -1, 0, 0};

    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                map[i][j] = in.nextInt();

        queue.offer(new int[]{1, 1});
        bfs();
        System.out.println(pathLen[n][m]);
    }

    private static void bfs() {
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            map[temp[0]][temp[1]] = 1;
            for(int i = 0;i<4;i++){
                int newX = temp[0]+x[i],newY = temp[1]+y[i];
                if(newX >= 1 && newX <= n && newY >= 1 && newY <= m && map[newX][newY]==0){
                    queue.offer(new int[]{newX,newY});
                    pathLen[newX][newY] = pathLen[temp[0]][temp[1]]+1;
                }
            }
        }
    }
}
