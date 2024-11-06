package Demo1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class demo7 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("./test.txt")){
            writer.write("你好世界",1,1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
