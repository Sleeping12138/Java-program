package Demo1;

import java.io.*;

public class demo12 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {


        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./test.txt"))){
            bufferedWriter.write("hello world");
            bufferedWriter.newLine();
            bufferedWriter.write("hello java");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String filePath = "hello";


        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

    }
}
