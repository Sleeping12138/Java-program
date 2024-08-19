package Demo3;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        binaryTree.sequence(root);
        System.out.println();

        int leafNodeCount = binaryTree.getLeafNodeCount(root);
        System.out.println(leafNodeCount);

        System.out.println(binaryTree.getKLevelNodeCount(root,3));

        System.out.println(binaryTree.getHeight(root));
    }


}
