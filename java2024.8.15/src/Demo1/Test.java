package Demo1;

public class Test {
    public static void main(String[] args) {
        BTree bt = new BTree();
        int[] array = {53, 139, 75, 49, 145, 36,101};
        for (int i = 0; i < array.length; i++) {
            bt.insert(array[i]);
        }

        System.out.println("hello world");

    }


}
