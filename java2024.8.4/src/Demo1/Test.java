package Demo1;

public class Test {
    public static void main(String[] args) {
        RBTree rbTree = new RBTree();
        rbTree.insert(2);
        rbTree.insert(5);
        rbTree.insert(1);
        rbTree.insert(7);
        rbTree.insert(9);
        rbTree.insert(0);
        rbTree.insert(4);
        rbTree.insert(3);
        rbTree.insert(8);
        rbTree.insert(10);

        rbTree.inorder(rbTree.root);
    }
}
