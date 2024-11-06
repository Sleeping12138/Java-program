package Demo2;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

// 服务器的创建
public class Server {
    private DatagramSocket datagramSocket = null;

    public Server(int port) throws SocketException {
        // 服务器一般需要指定端口
        datagramSocket = new DatagramSocket(port);
    }

    public void run() throws IOException {
        System.out.println("服务器已经启动...");
        while (true) {
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            datagramSocket.receive(requestPacket);

            String temp = new String(requestPacket.getData(), 0, requestPacket.getLength());

            String ret = temp;

            DatagramPacket responsePacket = new DatagramPacket(ret.getBytes(), ret.getBytes().length,
                    requestPacket.getSocketAddress());
            datagramSocket.send(responsePacket);
            System.out.println("数据响应成功");
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(9000);
        server.run();
    }
}
