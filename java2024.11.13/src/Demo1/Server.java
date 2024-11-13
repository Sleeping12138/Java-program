package Demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// 服务器的搭建
public class Server {
    private DatagramSocket datagramSocket = null;

    public Server(int port) throws SocketException {
        this.datagramSocket = new DatagramSocket(port);
    }

    public void run() throws IOException {
        while (true) {
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            datagramSocket.receive(requestPacket);

            String request = new String(requestPacket.getData(),0,requestPacket.getLength());

            String response = request;

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());
            datagramSocket.send(responsePacket);
            System.out.println("服务器响应完毕...");
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(9000);
        server.run();
    }
}
