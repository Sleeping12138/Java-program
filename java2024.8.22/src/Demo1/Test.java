package Demo1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        //常用于快速查找
        HashMap<String, Integer> map2 = new HashMap<>();
        //有序输出
        TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        map.put("bit",1);
        map.put("hello",1);
        map.put("the",1);
        map.put("world",1);
        map.put("coco",1);
        map.put("zhangsan",1);
        System.out.println(map.subMap("hello",""));

        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        map1.put(1,1);
        map1.put(2,1);
        map1.put(3,1);
        map1.put(4,1);
        map1.put(5,1);
        System.out.println(map1.tailMap(2));

        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        System.out.println(set.first());


    }
}
