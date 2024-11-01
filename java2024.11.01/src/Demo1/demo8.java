package Demo1;

import java.io.*;

public class demo8 {
    public static void main(String[] args) {
        try(InputStream inputStream=new FileInputStream("./test.txt")){
            while (true) {
                int read = inputStream.read();
                if(read==-1)break;
                System.out.println(read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(Reader reader = new FileReader("./test.txt")){

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 如果对象为二进制文件 -
        // 如果对象为文本文件 -
    }
}
