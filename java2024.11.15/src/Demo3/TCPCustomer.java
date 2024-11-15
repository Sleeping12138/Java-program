package Demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// 使用TCP创建客户端
public class TCPCustomer {
    private Socket socket = null;
    public TCPCustomer(String ip,int port) throws IOException {
        socket = new Socket(ip,port);
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream= socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()){
            Scanner customerScanner = new Scanner(inputStream);
            PrintWriter customerPrintWriter = new PrintWriter(outputStream);
            while (true) {
                System.out.print("请输入你要发送的信息:");
                String request = scanner.nextLine();

                customerPrintWriter.println(request);
                customerPrintWriter.flush();

                String response = customerScanner.nextLine();
                System.out.println(response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        TCPCustomer tcpCustomer = new TCPCustomer("127.0.0.1", 9000);
        tcpCustomer.run();
    }
}
