package Demo1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        Integer i = list.get(0);

        //只有一个空参构造
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.push(500);

//        System.out.println(stack);

//        Iterator<Integer> iterator = stack.iterator();
//        while (iterator.hasNext()){
//            System.out.print(iterator.next() + " ");
//        }

        ArrayList<Integer> arrayList = new ArrayList<>(stack);
        System.out.println(arrayList);

        LinkedList<Integer> list = new LinkedList<>(stack);
        System.out.println(list);
    }
}
