package Demo1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {1,6,2,3,7,9,10,5,4,8};
        MyHeap myHeap = new MyHeap(array);
        myHeap.makeBigHeap(array,array.length);
        for (int i = 0; i < myHeap.heap.length; i++) {
            System.out.print(myHeap.heap[i] + " ");
        }
        System.out.println();

        myHeap.offerBig(100);
        System.out.println(myHeap.peek());

        //遍历
        for (int i = 0; i < myHeap.heap.length; i++) {
            System.out.print(myHeap.heap[i] + " ");
        }
        System.out.println();

        myHeap.heapSort(myHeap.heap);
        for (int i = 0; i < myHeap.heap.length; i++) {
            System.out.print(myHeap.heap[i] + " ");
        }
        System.out.println();
    }
}
