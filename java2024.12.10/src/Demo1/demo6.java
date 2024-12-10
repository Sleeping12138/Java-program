package Demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class demo6 {
    public static void main(String[] args) {
//        InputStream inputStream = new FileInputStream();

//        try(InputStream inputStream = new FileInputStream("./test")){
//            while(true){
//                int ret = inputStream.read();
//                if(ret==-1) break;
//                System.out.print((char)ret);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try(InputStream inputStream = new FileInputStream("./test")){
//                byte[] bytes = new byte[10];
//            while (true) {
//                int ret = inputStream.read(bytes);
//                System.out.println(ret);
//                if(ret==-1)break;
//                for (int i = 0; i < ret; i++) {
//                    System.out.print((char)bytes[i]);
//                }
//                System.out.println();
//            }
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (InputStream inputStream = new FileInputStream("./test")) {
            byte[] bytes = new byte[100];
            int ret = inputStream.read(bytes, 10, 10);
            System.out.println(ret);
            for (int i = 0; i < bytes.length; i++) {
                System.out.print((char) bytes[i]);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
