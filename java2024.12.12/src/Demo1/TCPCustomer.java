package Demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPCustomer {
    public Socket socket;

    public TCPCustomer(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner in = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            String request = scanner.nextLine();
            printWriter.println(request);
            printWriter.flush();

            String ret = in.nextLine();
            System.out.println(ret);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
