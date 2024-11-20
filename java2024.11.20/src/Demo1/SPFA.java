package Demo1;

import java.util.*;

public class SPFA {
    public static int N = 510;
    public static int n, m;
    public static int[] path = new int[N];
    public static Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
    public static boolean[] vis = new boolean[N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashMap<>());
        }

        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            map.get(x).put(y, Math.min(map.get(x).getOrDefault(y, Integer.MAX_VALUE), z));
        }

        System.out.println(spfa());
    }

    private static int spfa() {
        Arrays.fill(path, Integer.MAX_VALUE);
        path[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        vis[1] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            vis[temp] = false;

            if (map.containsKey(temp)) {
                for (Map.Entry<Integer, Integer> entry : map.get(temp).entrySet()) {
                    int next = entry.getKey(), weight = entry.getValue();

                    if (path[next] > path[temp] + weight) {
                        path[next] = path[temp] + weight;
                        if (!vis[next]) {
                            queue.offer(next);
                            vis[next] = true;
                        }
                    }
                }
            }
        }

        return path[n] == Integer.MAX_VALUE ? -1 : path[n];
    }
}


