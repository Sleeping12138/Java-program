package Demo1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class demo5 {
//    public static void main(String[] args) {
//        try(OutputStream outputStream = new FileOutputStream("./test.txt",true)){
//            outputStream.write(97);
//            outputStream.write(97);
//            outputStream.write(97);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main(String[] args) {
        try(OutputStream outputStream = new FileOutputStream("./test.txt")){
            byte[] bytes = {97,98,99,100,101};
            outputStream.write(bytes,1,1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
