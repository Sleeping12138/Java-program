package Demo1;

import java.util.*;

public class demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        // 处理每个测试用例
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
                return Integer.compare((a[0] + a[1]), (b[0] + b[1]));
            });
            HashMap<String, Integer> map = new HashMap<>();

            // 输入任务
            for (int j = 0; j < N; j++) {
                int t = in.nextInt(), d = in.nextInt(), l = in.nextInt();
                String key = t + "," + d; // 使用字符串作为键
                queue.offer(new int[]{t, d});
                map.put(key, l);
            }

            // 处理任务
            int[] head = queue.poll();
            int time = head[0] + map.get(head[0] + "," + head[1]);
            boolean flag = true;

            while (!queue.isEmpty()) {
                int[] top = queue.poll();
                int start = top[0], end = top[1], len = map.get(top[0] + "," + top[1]);
                if (time < start) {
                    time = start;
                }
                if (time <= start + end) {
                    time += len;
                } else {
                    flag = false;
                    break;
                }
            }

            // 输出结果
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

