package Demo3;

import java.util.*;

public class Test {
    //    public static void main(String[] args) {
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.insertNode(5);
//        bst.insertNode(7);
//        bst.insertNode(10);
//        bst.insertNode(4);
//        bst.insertNode(1);
//        bst.insertNode(3);
//
//        bst.remove(3);
//
//        System.out.println();
//    }
    public static void main(String[] args) {
        //Map的使用
//        TreeMap<String, Integer> map = new TreeMap<>();
//        map.put("hello",3);
//        map.put("the",2);
//        map.put("world",1);
//
//        System.out.println(map);
//
////        map.remove("the");
//
//        System.out.println(map);
//
//        System.out.println(map.get("hello"));
//        //没有就为指定值
//        System.out.println(map.getOrDefault("null",100));
//
//        System.out.println(map.containsKey("5"));
//        System.out.println(map.containsValue(5));
//
////        Set<String> strings = map.keySet();
////        System.out.println(strings);
//
////        Collection<Integer> values = map.values();
////        System.out.println(values);
//
//        //获取的是一个一个节点
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
//        System.out.println(entries);

        //Set的使用
        //添加
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
        TreeSet<Integer> set = new TreeSet<>();
        set.add(100);
        set.add(200);
        set.add(300);
        set.add(400);
//        set.addAll(arrayList);

//        System.out.println(set);
//        set.clear();
//        System.out.println(set);

//        System.out.println(set.contains(10));

//        System.out.println(set.size());

//        Object[] array = set.toArray();
//        System.out.println(Arrays.toString(array));

//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next() + " ");
//        }


        //hash存储的顺序是随机的，Tree是按照比较的大小顺序存储
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("hello", 100);
        map.put("world",20);
        map.put("the",17);
        map.put("coco",25);
        map.put("zhangsan",10);
        map.put("lisi",5);
        System.out.println(map);
    }


}
