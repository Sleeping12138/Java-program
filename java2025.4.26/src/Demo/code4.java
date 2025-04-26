package Demo;

import java.util.ArrayList;
import java.util.Iterator;

public class code4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (Integer i : list){
            System.out.println(i);
            list.remove(Integer.valueOf(i));
        }

        System.out.println(list);

//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer next = iterator.next();
//            iterator.remove();
//        }
//
//        System.out.println(list);
    }
}
