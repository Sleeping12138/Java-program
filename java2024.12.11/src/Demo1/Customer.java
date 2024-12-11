package Demo1;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Customer {
    public DatagramSocket datagramSocket;
    public String ip;
    public int port;

    public Customer() throws SocketException {
        datagramSocket = new DatagramSocket();
        ip = "127.0.0.1";
        port = 8080;
    }

        Scanner in = new Scanner(System.in);
    public void run() throws IOException {
        while (true) {
            String str = in.nextLine();

            // InetAddress.getByName() 的核心功能就是解析一个 URL 或 IP 地址字符串，然后生成一个 InetAddress 对象
            DatagramPacket requestPacket = new DatagramPacket(str.getBytes(), 0, str.getBytes().length,
                    InetAddress.getByName(ip), port);

            datagramSocket.send(requestPacket);

            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            datagramSocket.receive(requestPacket);

            String ret = new String(requestPacket.getData(), 0, requestPacket.getLength());
            System.out.println(ret);
        }
    }

    public static void main(String[] args) throws IOException {
        Customer customer = new Customer();
        customer.run();
    }
}
