package Demo3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(4,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size()>4;
            }
        };
        map.put("hello",1);
        map.put("this",2);
        map.put("world",3);
        map.put("zhangsan",4);
        System.out.println(map);
        map.put("lisi",5);
        System.out.println(map);
        map.get("zhangsan");
        System.out.println(map);

    }
}
