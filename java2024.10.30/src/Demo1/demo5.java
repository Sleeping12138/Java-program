package Demo1;

import java.io.File;
import java.util.Arrays;

public class demo5 {
    public static void main(String[] args) {
//        File file = new File("C:/");
////        String[] ret = file.list();
//        File[] ret = file.listFiles();
//        System.out.println(Arrays.toString(ret));

        File file = new File("./test/a/b/c");
//        file.mkdir();

        file.mkdirs();

    }
}
