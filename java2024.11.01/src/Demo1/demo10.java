package Demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class demo10 {
    public static void main(String[] args) {
        String filePath = "test.txt"; // 指定要读取的文件路径

        // 使用 try-with-resources 确保资源自动关闭
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line; // 用于存储每一行文本
            while ((line = bufferedReader.readLine()) != null) { // 按行读取
                System.out.println(line); // 打印每一行
            }
        } catch (IOException e) {
            e.printStackTrace(); // 处理异常
        }
    }
}

