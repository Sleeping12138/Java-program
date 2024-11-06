package Demo1;

import java.util.*;

public class demo8 {
    public static void main(String[] args) {
        // map是按照key的自然顺序进行排序的
//        TreeMap<Integer, String> map = new TreeMap<>((a, b) -> a - b);
//        map.put(1, "hello");
//        map.put(3, "world");
//        map.put(4, "java");
//        map.put(5, "C++");
//        map.put(2, "the");
//
//
//        System.out.println(map.firstEntry().getValue());
//        System.out.println(map.lastEntry().getValue());
//        Map<Integer, String> temp = map.subMap(2,5);
//
//        for(Map.Entry<Integer,String> ret : temp.entrySet()){
//            System.out.println(ret);
//        }

//        for(Map.Entry<Integer,String> entry : map.entrySet()){
//            System.out.println(entry);
//        }

//        TreeSet<Integer> set = new TreeSet<>((a,b)->b-a);
//        for (int i = 0; i < 10; i++) {
//            set.add(i);
//        }
//        System.out.println(set);
//        for(int number : set){
//            System.out.println(number);
//        }

//        TreeSet<Integer> set = new TreeSet<>((a,b)->b-a);
//        for (int i = 0; i < 10; i++) {
//            set.add(i);
//        }
//
//        System.out.println(set.first());
//        System.out.println(set.last());
//        Set<Integer> temp = set.subSet(7,4);
//        for(int number : temp){
//            System.out.println(number);
//        }
//
//        for (int number : set) {
//            System.out.println(number);
//        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(2);
        set2.add(3);
        set2.add(4);

        set1.retainAll(set2);
        System.out.println(set1);



    }
}
