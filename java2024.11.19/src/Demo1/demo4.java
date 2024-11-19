//package Demo1;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class demo4 {
//    static int N = 510, M = 10010;
//    static int n, m, k;
//    static int dist[] = new int[N], backup[]; // dist[]: 放最下路径的权值;    backup[]: 放上一次迭代的dist[];
//    static Edge edge[] = new Edge[M]; // 边的对象数组
//
//    static int bellman_ford() {
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[1] = 0;
//
//        for (int i = 0; i < k; i++) {
//            backup = Arrays.copyOf(dist, dist.length);
//            for (int j = 0; j < m; j++) {
//                int a = edge[j].a, b = edge[j].b, w = edge[j].w;
//                if (backup[a] != Integer.MAX_VALUE && dist[b] > dist[a] + w) {
//                    dist[b] = dist[a] + w;
//                }
//            }
//        }
//
////        if (dist[n] > 0x3f3f3f3f / 2) return -1;  // 现在过不了了，因为数据经过完善，会有监测-1的测试案例
//        if (dist[n] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
//        // 这里(dist[n] > 0x3f3f3f3f / 2)而不是(dist[n] == 0x3f3f3f3f)是，如果这条边后面有负边这里0x3f3f3f3f会因为迭代跟着可能一起递减
//        return dist[n];
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        m = in.nextInt();
//        k = in.nextInt();
//        for (int i = 0; i < m; i++) {
//            int a = in.nextInt(), b = in.nextInt(), w = in.nextInt();
//            edge[i] = new Edge(a, b, w);
//        }
//        int t = bellman_ford();
//
////        if (t == -1) System.out.println("impossible"); // // 现在过不了了，因为数据经过完善，会有监测-1的测试案例
//        if (t == Integer.MAX_VALUE) System.out.println("impossible");
//        else System.out.println(t);
//    }
//}
//
//class Edge { // 用Edge类的对象来存边
//    int a, b, w;
//
//    public Edge(int a, int b, int w) {
//        this.a = a;
//        this.b = b;
//        this.w = w;
//    }
//}
//
//
