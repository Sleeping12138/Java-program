package Demo1;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(3);
        bst.insertNode(4);
        bst.insertNode(6);
        bst.insertNode(7);
        bst.insertNode(8);
        bst.insertNode(1);
        bst.insertNode(5);
        bst.insertNode(2);
        bst.insertNode(0);
        bst.remove(5);


//        BinarySearchTree.TreeNode node = bst.findNode(7);
//        System.out.println(node.val);

    }
}
