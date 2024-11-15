package Demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 使用TCP创建服务器
public class TCPServer {
    private ServerSocket serverSocket = null;

    public TCPServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() throws IOException {
        System.out.println("服务器启动成功...");
        while (true) {
            Socket client = serverSocket.accept();
            System.out.printf("客户端连接成功: %s -- %d\n", client.getInetAddress(), client.getPort());
            ExecutorService executorService = Executors.newCachedThreadPool();


            executorService.submit(()->{
                try {
                    processClient(client);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void processClient(Socket client) throws IOException {
        try (InputStream inputStream = client.getInputStream();
             OutputStream outputStream = client.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            while (true) {
                // 以回车形式来判断字节到哪里终止算作一条信息
                if (!scanner.hasNextLine()) {
                    System.out.printf("客户端关闭: %s -- %d\n", client.getInetAddress(), client.getPort());
                    break;
                }
                String request = scanner.nextLine();

                String response = process(request);

                printWriter.println(response);
                printWriter.flush();

                System.out.printf("[%s:%d] req: %s, resp: %s\n", client.getInetAddress(), client.getPort(),
                        request, response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            client.close();
        }
    }

    private String process(String request) {
        return request;
    }


    public static void main(String[] args) throws IOException {
        TCPServer tcpServer = new TCPServer(9000);
        tcpServer.run();
    }
}
