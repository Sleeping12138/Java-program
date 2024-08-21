package Demo1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        //Java中的比较 - equals、Comparator、Comparable

        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        System.out.println(array == array2);
        System.out.println(Arrays.equals(array,array2));

        Student student1 = new Student("zhangsan",18);
        Student student2 = new Student("zhangsan", 18);
        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->b-a);

    }
}
