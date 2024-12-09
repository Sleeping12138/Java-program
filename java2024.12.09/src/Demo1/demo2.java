package Demo1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class demo2 {
    public static void main(String[] args) {
        File file = new File("D:\\javacode\\test.txt");
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            long length = raf.length();
            for (long i = length - 1; i >= 0; i--) {
                raf.seek(i);
                System.out.print((char) raf.readByte());
            }
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
