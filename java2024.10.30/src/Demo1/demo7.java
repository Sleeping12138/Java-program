package Demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class demo7 {
    public static void main(String[] args) throws IOException {

//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream("./text.txt");
//        } finally {
//            inputStream.close();
//
//        }

//        try (InputStream inputStream = new FileInputStream("./text.txt")) {
//            // 单个字节读取
//            while (true) {
//                int read = inputStream.read();
//                // 读取到结尾返回-1
//                if (read==-1){
//                    break;
//                }
//                System.out.print((char)read);
//            }
//        }

//        try(InputStream inputStream = new FileInputStream("./text.txt")){
//            byte[] bytes = new byte[100];
//            while (true) {
//                //输出型参数
//                int read = inputStream.read(bytes);
//                if(read==-1){
//                    break;
//                }
//                for (int i = 0; i < read; i++) {
//                    System.out.print((char) bytes[i]);
//                }
//            }
//        }

        try (InputStream inputStream = new FileInputStream("./text.txt")) {
            // int bytesRead = inputStream.read(buffer, offset, length);
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer, 0, 10);
        }


    }
}

