package Demo1;

import java.io.File;

public class demo6 {
    public static void main(String[] args) {
        File file  = new File("./text");
        file.renameTo(new File("./text.txt"));
    }
}
