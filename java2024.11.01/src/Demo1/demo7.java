package Demo1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class demo7 {
    public static void main(String[] args) {

        try (Writer writer = new FileWriter("./test.txt", true)) {


            writer.write("hello world");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
