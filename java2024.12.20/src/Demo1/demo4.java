package Demo1;

import java.util.*;

// 主流的解决方法：贪心 、 搜索
// 思想和全排列很相似

class Plane {
    int t, d, l;
    public Plane(int t, int d, int l) {
        this.t = t;
        this.d = d;
        this.l = l;
    }
}

public class demo4 {
    public static boolean[] visited;
    public static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            Plane[] planes = new Plane[N];

            for (int j = 0; j < N; j++) {
                int t = in.nextInt(), d = in.nextInt(), l = in.nextInt();
                planes[j] = new Plane(t, d, l);
            }

            visited = new boolean[N];
            // 全局变量在有多组输入的时候要恢复
            flag = false;

            dfs(0, 0, planes);

            System.out.println(flag ? "YES" : "NO");
        }
    }

    public static void dfs(int number, int currentTime, Plane[] planes) {
        if (number >= planes.length) {
            flag = true;
            return;
        }

        for (int i = 0; i < planes.length; i++) {
            Plane plane = planes[i];
            int arriveTime = plane.t, maxDelayTime = plane.d, landingTime = plane.l;
            
            if (visited[i]||currentTime > arriveTime + maxDelayTime) continue;

            visited[i] = true;
            dfs(number + 1, Math.max(currentTime, arriveTime) + landingTime, planes);
            if (flag) return;

            // 由于有全局变量的改变，所有回溯时要进行恢复现场
            visited[i] = false;
        }
    }
}
