package Demo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo4 {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String targetFile = "target.txt";

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(targetFile)
        ) {
            int data;
            while ((data = fis.read())!= -1) {
                fos.write(data);
            }
            System.out.println("成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}