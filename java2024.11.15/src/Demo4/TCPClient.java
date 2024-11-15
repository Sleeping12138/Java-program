package Demo4;

import Demo2.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

// 使用TCP创建客户端
public class TCPClient {
    private Socket socket = null;

    public TCPClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            while (true) {
                System.out.print("请输入要发送的内容：");

                String request = in.nextLine();

                // 如果这里使用的是print则不会发出信息
                printWriter.println(request);
                printWriter.flush();
                String response = scanner.nextLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        TCPClient tcpClient = new TCPClient("127.0.0.1", 9000);
        tcpClient.run();
    }
}
