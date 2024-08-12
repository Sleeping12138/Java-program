package Demo1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);

        //使用for循环
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();

        for (int num : arrayList) {
            System.out.print(num + " ");
        }
        System.out.println();

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ListIterator<Integer> integerListIterator = arrayList.listIterator(4);
        while (integerListIterator.hasPrevious()) {
            System.out.print(integerListIterator.previous() + " ");
        }

//        System.out.println(arrayList);
//
//
//        ArrayList<Integer> arrayList1 = new ArrayList<>(arrayList);
//        System.out.println(arrayList1);
    }
}
