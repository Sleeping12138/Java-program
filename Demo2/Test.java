package Demo2;

public class Test {
    public static void main(String[] args) {
        MySingleList list = new MySingleList();
        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(3);
//        list.addLast(3);
//        list.addLast(4);
        list.removeAll(3);
        list.printList();
//        System.out.println(list.size());
    }
}
