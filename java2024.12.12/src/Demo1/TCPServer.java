package Demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {
    public ServerSocket serverSocket;

    public TCPServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() throws IOException {
        while (true) {
            Socket customer = serverSocket.accept();
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.submit(() -> {
                try {
                    process(customer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        }
    }

    private void process(Socket customer) throws IOException {
        try (InputStream inputStream = customer.getInputStream();
             OutputStream outputStream = customer.getOutputStream()) {
            Scanner in = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            while (true) {
                if(!in.hasNext()){
                    break;
                }
                String request = in.nextLine();
                String response = request;
                printWriter.println(response);
                printWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            customer.close();
        }

    }
}
