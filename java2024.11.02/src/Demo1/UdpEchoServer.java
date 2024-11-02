package Demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        // 指定了一个固定端口号, 让服务器来使用.
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        // 启动服务器
        System.out.println("服务器启动");

        while (true) {
            // 1. 读取请求并解析.
            //    DatagramPacket 表示一个 UDP 数据报. 此处传入的字节数组, 就保存 UDP 的载荷部分.
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(requestPacket);
            //    把读取到的二进制数据, 转成字符串. 只是构造有效的部分.
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());

            // 2. 根据请求, 计算响应. (服务器最关键的逻辑)
            //    但是此处写的是回显服务器. 这个环节相当于省略了.
            String response = process(request);

            // 3. 把响应返回给客户端
            //    根据 response 构造 DatagramPacket, 发送给客户端.
            //    此处不能使用 response.length()
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            //    此处还不能直接发送. UDP 协议自身没有保存对方的信息(不知道发给谁)
            //    需要指定 目的 ip 和 目的端口.
            socket.send(responsePacket);

            // 4. 打印一个日志
            System.out.printf("[%s:%d] req: %s, resp: %s\n", requestPacket.getAddress().toString(), requestPacket.getPort(),
                    request, response);
        }
    }

    // 后续如果要写别的服务器, 只修改这个地方就好了.
    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
