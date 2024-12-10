package Demo1;

import java.io.*;

public class demo9 {
    public static void main(String[] args) {
//        try(Writer writer = new FileWriter("./test")){
//            writer.write("我不喜欢你");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("./test"))){

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("./test"))) {

        }
    }
}
