package Demo1;

import java.util.*;

public class demo1 {
    static int N = 11010, n, m, cnt;
    static int[] w = new int[N], v = new int[N], f = new int[2010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), s = sc.nextInt();
            int k = 1;
            while (s >= k) {
                cnt++;
                v[cnt] = k * a;
                w[cnt] = k * b;
                s -= k;
                k *= 2;
            }
            if (s > 0) {
                cnt++;
                v[cnt] = s * a;
                w[cnt] = s * b;
            }
        }

        for (int i = 1; i <= cnt; i++)
            for (int j = m; j >= v[i]; j--)
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);

        System.out.println(f[m]);

    }
}

