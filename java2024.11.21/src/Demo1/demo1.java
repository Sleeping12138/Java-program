package Demo1;

import java.util.Scanner;

public class demo1 {
    public static int ret = 0, len = 0, forward = -1;
    public static int n, m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            n = in.nextInt();
            m = in.nextInt();

            dfs(0);
            System.out.println(ret);
        }
    }

    public static void dfs(int number) {
        if (number == m) {
            ret++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (i == forward) continue;
            forward = i;
            dfs(number + 1);
            forward = i;
        }
    }
}
