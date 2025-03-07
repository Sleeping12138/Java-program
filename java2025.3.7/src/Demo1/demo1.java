package Demo1;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo1 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan-1");
        list.add("lisi-2");
        list.add("wangwu-3");

        list.stream().collect(Collectors.toMap(new Function<String, String>() {
            @Override
            public String apply(String string) {
                return string.split("-")[0];
            }
        }, new Function<String, Integer>() {
            @Override
            public Integer apply(String string) {
                return Integer.parseInt(string.split("-")[1]);
            }
        }));

        list.stream().collect(Collectors.toMap(s->s.split("-")[0],s->Integer.parseInt(s.split("-")[1])));

//        Set<String> collect = list.stream().collect(Collectors.toSet());
//        System.out.println(collect);

//        String[] array = list.stream().toArray(value -> new String[value]);
//        System.out.println(Arrays.toString(array));

//        long count = list.stream().count();
//        System.out.println(count);

//        list.stream().map(s -> Integer.parseInt(s.split("-")[1])).forEach(x -> System.out.println(x));

//        Stream.concat(list.stream(), list.stream()).forEach(x -> System.out.println(x));

//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);
//        list.stream().filter(x->x<=3).forEach(x-> System.out.println(x));

//
//        list.stream().forEach(x-> System.out.println(x));


//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//
//        list.add(8);

//        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
//
//        Map<String, Integer> map = Map.of(
//                "Alice", 25,
//                "Bob", 30,
//                "Charlie", 28
//        );
//
//        System.out.println(map);
//
//        HashMap<String,Integer> map = new HashMap<>();
//        map.put("Alice", 25);
//        map.put("Bob", 30);
//        map.put("Charlie", 28);
//
//        Map<String, Integer> map2 = Map.copyOf(map);
//
//        System.out.println(map2);
//        Map<String, Integer> map2 = Map.ofEntries(map.entrySet().toArray(new Entry[0]));


//        HashMap<String,Integer> map = new HashMap<>();
//        map.put("Alice", 25);
//        map.put("Bob", 30);
//        map.put("Charlie", 28);
//
//        map.keySet().stream().forEach(x-> System.out.println(x));

//        int[] array = {1,2,3,4,5};
//        Arrays.stream(array).forEach(x-> System.out.println(x));

//        Stream.of(1,2,3,4,5).forEach(x-> System.out.println(x));

    }
}
