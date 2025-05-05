package Demo;

import java.util.ArrayList;
import java.util.Iterator;

public class code1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            int next = iterator.next();
            list.add(6);
            System.out.println(next);
        }

        
    }
}
