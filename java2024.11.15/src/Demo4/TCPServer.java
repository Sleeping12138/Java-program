package Demo4;

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
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket client = serverSocket.accept();
            System.out.printf("成功连接服务器：%s --- %d",client.getInetAddress(),client.getPort());
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
        try(InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            while (true) {
                String request = scanner.nextLine();

                String response = process(request);

                printWriter.println(response);
                printWriter.flush();

                System.out.printf("[%s:%d] req: %s, resp: %s\n", client.getInetAddress(), client.getPort(),
                        request, response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
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
