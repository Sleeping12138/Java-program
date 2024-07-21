package Demo2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        //优先队列的使用

        //优先队列的创建
        //空参
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        //初始化堆的大小
//        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(30);
//
//        //传入比较器
//        PriorityQueue<Integer> priorityQueue3 = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        //比较器 + 初始大小
//        PriorityQueue<Integer> priorityQueue4 = new PriorityQueue<>(30, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        //传入集合进行初始化
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        arrayList.add(5);
//        PriorityQueue<Integer> priorityQueue5 = new PriorityQueue<>(arrayList);

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.offer(100);
        priorityQueue.offer(200);
        priorityQueue.offer(300);
        priorityQueue.offer(400);

        //默认为小根堆 - 想要转换为大根堆要传入比较器
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.isEmpty());
        System.out.println(priorityQueue.size());
        priorityQueue.clear();
        System.out.println(priorityQueue.size());

        //PriorityQueue的常用方法 - offer + poll + peek + size + isEmpty
    }
}
