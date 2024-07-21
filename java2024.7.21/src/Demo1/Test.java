package Demo1;

public class Test {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 8, 10, 3, 9, 7, 4};
        MyHeap myHeap = new MyHeap(array);
        myHeap.makeBigHeap(myHeap.elem, myHeap.useSize);
        myHeap.offerBig(100);
        int peek = myHeap.peek();
        System.out.println(peek);
        myHeap.printHeap();


    }
}
