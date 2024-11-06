package Demo1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class demo6 {
//    public static void main(String[] args) {
//        try(Reader reader = new FileReader("./test.txt")) {
//            while (true) {
//                int read = reader.read();
//                if (read == -1) {
//                    break;
//                }
//                System.out.println((char)read);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main(String[] args) {
        try(Reader reader =new FileReader("./test.txt")){
            char[] chs = new char[1024];
            while(true){
                int read = reader.read(chs);
                if (read == -1) {
                    break;
                }
                for (int i = 0; i < read; i++) {
                    System.out.println(chs[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
