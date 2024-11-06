package Demo1;

import java.io.*;

public class demo3 {
    public static void main(String[] args) throws IOException {
        // 快速读取
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 在使用System.in不用手动的调用close方法，当程序执行完毕的时候会自动关闭

        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int count = 0;
        while(count<=5){
            count++;
            String str = bf.readLine();
            printWriter.println(str);
        }

        // 打印的时候将数据写到了缓冲区中，只有刷新的时候才会将输出出来

        printWriter.close();
    }


}
