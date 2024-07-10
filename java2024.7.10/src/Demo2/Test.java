package Demo2;

public class Test {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
//        list.addFirst(1);
//        list.addFirst(2);
//        list.addFirst(3);
//        list.addFirst(4);
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(3);
        list.addLast(4);
        list.printList();
        System.out.println(list.size());
        list.remove(2);
        list.printList();
        list.removeAll(3);
        list.printList();
        list.clear();
        list.printList();
        System.out.println("------------------");


    }
}
