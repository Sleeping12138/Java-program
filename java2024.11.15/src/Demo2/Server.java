package Demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// 服务器的创建
public class Server {
    private DatagramSocket datagramSocket = null;
    public Server(int port) throws SocketException {
        datagramSocket = new DatagramSocket(port);
    }

    public void run() throws IOException {
        while (true) {
            System.out.println("服务器启动成功...");
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            datagramSocket.receive(requestPacket);

            String request = new String(requestPacket.getData(),0,requestPacket.getLength());

            // 核心业务
            String ret = process(request);

            DatagramPacket responsePacket = new DatagramPacket(ret.getBytes(),0,ret.getBytes().length,
                    requestPacket.getSocketAddress());
            datagramSocket.send(responsePacket);
            System.out.println("服务器响应成功...");
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(9000);
        server.run();
    }
}
