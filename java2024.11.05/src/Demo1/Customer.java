package Demo1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Customer {
    private DatagramSocket datagramSocket = null;

    private int port;
    private String ip;
    public Customer(String ip,int port) throws SocketException {
        this.port = port;
        this.ip = ip;
        datagramSocket = new DatagramSocket();
    }

    public void run() throws IOException {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();

            DatagramPacket requestPocket = new DatagramPacket(str.getBytes(),str.getBytes().length,
                    InetAddress.getByName(ip),port);
            datagramSocket.send(requestPocket);

            DatagramPacket responsePocket = new DatagramPacket(new byte[4096],4096);
            datagramSocket.receive(responsePocket);

            String ret = new String(responsePocket.getData(),0,responsePocket.getLength());
            System.out.println(ret);
        }
    }


    public static void main(String[] args) throws IOException {
        Customer customer = new Customer("127.0.0.1", 9000);
        customer.run();
    }
}
