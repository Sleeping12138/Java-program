package Demo1;

import java.io.*;

public class demo5 {
    public static void main(String[] args) throws FileNotFoundException {

//        try (OutputStream outputStream = new FileOutputStream("./test.txt", true)) {
//
//
//            // 写入的时候是字节，但是文件在展示的时候会根据字符编码（如 ASCII 或 UTF-8）来展示这些字节
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//
//        try (OutputStream outputStream = new FileOutputStream("./test.txt")) {
//            byte[] bytes = {97, 98, 99, 100};
//            outputStream.write(bytes,1,2);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        try(InputStream inputStream = new FileInputStream("./test.txt")){
            inputStream.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
