package Demo1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class demo11 {
    public static void main(String[] args) throws IOException {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./test.txt"))) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                System.out.println(line);
            }
        }

    }
}
