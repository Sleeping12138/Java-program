package Demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

// 客户端的创建
public class Customer {
    private DatagramSocket datagramSocket = null;

    private String ip;
    private int port;
    public Customer(String ip,int port) throws SocketException {
        this.ip = ip;
        this.port = port;
        datagramSocket = new DatagramSocket();
    }

    public void run() throws IOException {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("请输入你要返回的数据：");
            String request = in.nextLine();
            DatagramPacket datagramPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(ip),port);
            datagramSocket.send(datagramPacket);

            DatagramPacket resposePacket = new DatagramPacket(new byte[4096],4096);
            datagramSocket.receive(resposePacket);
            String ret = new String(resposePacket.getData(),0,resposePacket.getLength());
            System.out.println(ret);
        }
    }

    public static void main(String[] args) throws IOException {
        Customer customer = new Customer("127.0.0.1", 9000);
        customer.run();
    }
}
