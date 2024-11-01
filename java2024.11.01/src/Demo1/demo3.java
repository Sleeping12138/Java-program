package Demo1;

import java.util.*;
import java.io.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class demo3 {
    public static PrintWriter out = new PrintWriter(new BufferedWriter(
            new OutputStreamWriter(System.out)));
    public static Read in = new Read();

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                ret[i][j] = sumNumber(array,i,j,n,m);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                out.print(ret[i][j]+" ");
            }
            out.println();
        }
        out.close();
    }
    public static int sumNumber(int[][] array,int i,int j,int n,int m){
        int sum = 0;
        for(int k = 0;k<n;k++) {
            sum += array[k][j];
        }
        for(int k = 0;k<m;k++) {
            sum += array[i][k];
        }
        sum-=array[i][j];
        return sum;
    }
}


class Read { // 自定义快速读入
    StringTokenizer st = new StringTokenizer("");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(bf.readLine());
        }
        return st.nextToken();
    }

    String nextLine() throws IOException {
        return bf.readLine();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
