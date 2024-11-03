package Demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

//客户端
public class MyUdpEchoClient {
    private DatagramSocket datagramSocket = null;
    private String ip;
    private int port;

    public MyUdpEchoClient(String ip, int port) throws SocketException {
        datagramSocket = new DatagramSocket();
        this.ip = ip;
        this.port = port;
    }

    public void run() throws IOException {
        System.out.println("客户端已经启动...");
        Scanner scanner = new Scanner(System.in);
        while (true) {


            System.out.print("请输入要发送的数据: ");
            String information = scanner.nextLine();

            // ip和port已经设置
            DatagramPacket requestPacket = new DatagramPacket(information.getBytes(), information.getBytes().length,
                    InetAddress.getByName(ip), port);
            datagramSocket.send(requestPacket);

            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            datagramSocket.receive(responsePacket);

            String ret = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(ret);


        }
    }

    public static void main(String[] args) throws IOException {
        MyUdpEchoClient myUdpEchoClient = new MyUdpEchoClient("127.0.0.1", 9000);
        myUdpEchoClient.run();
    }
}
