package Demo1;

import java.io.File;
import java.io.IOException;

public class demo4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("./text.txt");
//        System.out.println(file.getParent());
//        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());

//        File file = new File("./text.txt");
//
    }
}
