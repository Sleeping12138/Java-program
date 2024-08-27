package Demo1;

public class Test {
    public static void main(String[] args) {

    }
//    class QueueNode {
//        TreeNode node;
//        int depth;
//
//        public QueueNode(TreeNode node, int depth) {
//            this.node = node;
//            this.depth = depth;
//        }
//    }
//
//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        Queue<QueueNode> queue = new LinkedList<QueueNode>();
//        queue.offer(new QueueNode(root, 1));
//        while (!queue.isEmpty()) {
//            QueueNode nodeDepth = queue.poll();
//            TreeNode node = nodeDepth.node;
//            int depth = nodeDepth.depth;
//            if (node.left == null && node.right == null) {
//                return depth;
//            }
//            if (node.left != null) {
//                queue.offer(new QueueNode(node.left, depth + 1));
//            }
//            if (node.right != null) {
//                queue.offer(new QueueNode(node.right, depth + 1));
//            }
//        }
//
//        return 0;
//    }
}
