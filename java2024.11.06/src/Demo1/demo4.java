package Demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class demo4 {
    public static void main(String[] args) throws FileNotFoundException {
//        try(InputStream inputStream = new FileInputStream("./test.txt")){
//            while (true) {
//                int read = inputStream.read();
//                if(read==-1)break;
//                System.out.println(read);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try(InputStream inputStream = new FileInputStream("./test.txt");){
            byte[] bytes = new byte[1024];
            while (true) {
                int read = inputStream.read(bytes,3,14);
                if (read == -1) {
                    break;
                }
                for (int i = 0; i < read; i++) {
                    System.out.print((char)bytes[i]);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
