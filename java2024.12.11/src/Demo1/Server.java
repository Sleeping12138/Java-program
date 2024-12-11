package Demo1;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;

public class Server {
    public DatagramSocket datagramSocket;

    public Server() throws SocketException {
        datagramSocket = new DatagramSocket(8080);
    }

    public void run() throws IOException {
        while (true) {
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            datagramSocket.receive(requestPacket);

            String ret = new String(requestPacket.getData(), 0, requestPacket.getLength());
            String response = ret;

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), 0, response.getBytes().length,
                    new InetSocketAddress(requestPacket.getAddress(), requestPacket.getPort()));
            datagramSocket.send(responsePacket);
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
    }
}
