package Demo1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

// 模拟客户端
public class Consumer {
    private DatagramSocket datagramSocket = null;
    private String ip;
    private int port;

    public Consumer(String ip, int port) throws SocketException {
        this.ip = ip;
        this.port = port;
        datagramSocket = new DatagramSocket();
    }

    Scanner in = new Scanner(System.in);
    public void run() throws IOException {
        while (true) {
            System.out.print("请输入要发送的信息:");
            String str =in.nextLine();
            DatagramPacket requestPacket = new DatagramPacket(str.getBytes(),str.getBytes().length,
                    new InetSocketAddress(InetAddress.getByName(ip),port));
            datagramSocket.send(requestPacket);

            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            datagramSocket.receive(responsePacket);

            String ret = new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.println(ret);
        }
    }

    public static void main(String[] args) throws IOException {
        Consumer consumer = new Consumer("127.0.0.1", 9000);
        consumer.run();
    }
}
