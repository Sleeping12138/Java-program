package Demo1;

import java.io.*;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入源文件路径: ");
        String srcPath = scanner.next();
        System.out.println("请输入目标文件路径: ");
        String destPath = scanner.next();
        File srcFile = new File(srcPath);
        if (!srcFile.isFile()) {
            System.out.println("源文件不存在或不是文件");
            return;
        }
        File destFile = new File(destPath);
        // 要求 destFile 不一定存在.
        // 但是 destFile 所在的目录必须存在.
        // 例如, destFile 为 d:/test/test.txt, 则要求 d:/test 目录存在.
        if (!destFile.getParentFile().isDirectory()) {
            System.out.println("目标文件所在目录不存在");
            return;
        }

        // 真正进行复制文件的操作
        // 此处不应该使用追加写. 需要确保目标文件和源文件一模一样.
        try (InputStream inputStream = new FileInputStream(srcFile);
             OutputStream outputStream = new FileOutputStream(destFile)) {
            while (true) {
                byte[] buf = new byte[1024];
                int n = inputStream.read(buf);
                if (n == -1) {
                    break;
                }
                // 此处的 write 不应该写整个 buf 数组的.
                // buf 数组不一定被填满. 要按照实际的 n 这个长度来写入
                // 读多少, 写多少
                outputStream.write(buf, 0, n);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}