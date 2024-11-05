package Demo1;

import java.io.*;

public class demo5 {
//    public static void main(String[] args) throws IOException {
        // 输入一行数据极多的时候
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//
//        // 当输出量极大的时候
//        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//
//
//        String str = bf.readLine();
//
//        out.println(str);
//    }


    public static void main(String[] args) {
        // 海量数据的读取
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 海量数据的输出
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        printWriter.println();
    }
}


