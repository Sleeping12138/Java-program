package Demo2;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class HashMapServer extends Server{
    private HashMap<String,String> map = new HashMap<>();

    public HashMapServer(int port) throws SocketException {
        super(port);
        map.put("1","dog");
        map.put("2","cat");
        map.put("3","bird");
        map.put("4","pig");
        map.put("5","house");
    }

    @Override
    public String process(String request) {
        return map.getOrDefault(request, "没有找到对应的动物...");
    }

    public static void main(String[] args) throws IOException {
        HashMapServer hashMapServer = new HashMapServer(9000);
        hashMapServer.run();
    }
}
