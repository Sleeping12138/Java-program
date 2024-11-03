package Demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

// 服务端
public class MyUdpEchoServer {
    DatagramSocket datagramSocket = null;

    public MyUdpEchoServer(int port) throws SocketException {
        this.datagramSocket = new DatagramSocket(port);
    }

    public void run() throws IOException {
        System.out.println("服务端已经启动...");
        while (true) {


            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            datagramSocket.receive(requestPacket);

            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());

            // 处理请求返回响应
            String response = request;

            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), 0, response.getBytes().length,
                    new InetSocketAddress(requestPacket.getAddress(), requestPacket.getPort()));
            datagramSocket.send(responsePacket);

            System.out.println("服务端响应完毕...");


        }
    }

    public static void main(String[] args) throws IOException {
        MyUdpEchoServer myUdpEchoServer = new MyUdpEchoServer(9000);
        myUdpEchoServer.run();
    }
}
