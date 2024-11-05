package Demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// 创建服务器
public class Server {
    private DatagramSocket datagramSocket = null;
    public Server(int port) throws SocketException {
        // 服务器固定端口号
        datagramSocket = new DatagramSocket(port);
    }

    public void run() throws IOException {
        System.out.println("服务器已经启动....");
        while (true) {
            DatagramPacket requestPocket = new DatagramPacket(new byte[4096],4096);
            datagramSocket.receive(requestPocket);

            String temp  = new String(requestPocket.getData(),0,requestPocket.getLength());

            String ret = temp;

            DatagramPacket responsePocket = new DatagramPacket(ret.getBytes(),0,requestPocket.getLength(),
                    requestPocket.getAddress(),requestPocket.getPort());
            datagramSocket.send(responsePocket);
            System.out.println("数据成功响应...");

        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(9000);
        server.run();
    }

}
