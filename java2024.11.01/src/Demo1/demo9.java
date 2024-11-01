package Demo1;

import java.util.*;

public class demo9 {
    public static void main(String[] args) {

        HashMap<String,Integer> map = new HashMap<>();
        map.put("hello",1);
        map.put("the",2);
        map.put("word",3);

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry);
        }

//        Set<String> strings = map.keySet();
//
//        Collection<Integer> values = map.values();
//        for(int number : values){
//            System.out.println(number);
//        }


//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(4);
//        set.add(5);
//
//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
