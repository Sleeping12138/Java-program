package Demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    private DatagramSocket datagramSocket = null;
    public Server(int port) throws SocketException {
        datagramSocket = new DatagramSocket(port);
    }

    public void run() throws IOException {
        System.out.println("服务器已经启动...");

        while(true){
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            datagramSocket.receive(requestPacket);

            String ret = new String(requestPacket.getData(),0,requestPacket.getLength());

            String result = ret;

            DatagramPacket responsePacket = new DatagramPacket(result.getBytes(),0,result.getBytes().length,
                    requestPacket.getSocketAddress());
            datagramSocket.send(responsePacket);

            System.out.println("响应成功返回...");
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(9000);
        server.run();
    }
}
