package Demo1;

import java.util.LinkedHashMap;

public class Test {
    public static void main(String[] args) {
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(10,0.75f,true);
//        map.put("zhangsan",18);
//        map.put("lisi",28);
//        map.put("wangwu",19);
//        map.put("zhaoliu",17);
//
//        System.out.println(map);
//
//        map.get("zhangsan");
//        System.out.println(map);


//        LRUCache lruCache = new LRUCache(3);
//        lruCache.put("zhangsan",18);
//        lruCache.put("lisi",28);
//        lruCache.put("wangwu",19);
//        System.out.println(lruCache);
//        lruCache.put("zhaoliu",17);
//        System.out.println(lruCache);
//        lruCache.get("lisi");
//        System.out.println(lruCache);

        MyLRUCache myLRUCache = new MyLRUCache(3);
        myLRUCache.put(1,18);
        myLRUCache.put(2,28);
        myLRUCache.put(3,19);
        myLRUCache.print();
        System.out.println("-------------------");
        myLRUCache.put(4, 100);
        myLRUCache.print();
    }
}
