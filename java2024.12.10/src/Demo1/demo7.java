package Demo1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class demo7 {
    public static void main(String[] args) {
//        try(OutputStream outputStream = new FileOutputStream("./test",true)){
//            for(int i  = 0;i<26;i++){
//                outputStream.write(i+97);
//            }
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try(OutputStream outputStream = new FileOutputStream("./test")){
            byte[] bytes = {97,98,99,100};
            outputStream.write(bytes,1,2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
