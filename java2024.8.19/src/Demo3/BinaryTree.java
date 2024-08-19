package Demo3;

import java.util.LinkedList;
import java.util.Queue;

//二叉树
public class BinaryTree {
    public static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public BinaryTree() {
    }

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;

        return A;
    }

    //二叉树的遍历
    //前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //层序遍历
    public void sequence(TreeNode root) {
        //涉及到了先后执行顺序
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            System.out.print(node.val + " ");
        }
    }

    //获得树中所有节点的个数
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    //获取叶子节点的总个数
    public int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }

    //获取第k层节点的总数
    public int getKLevelNodeCount(TreeNode root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }

    //获取树的高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    //判断树是否为一棵完全二叉树 - 使用层序遍历的原理判断是否为完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                break;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                return false;
            }
            queue.poll();
        }
        return true;
    }

    //判断当前节点是否存在
    public TreeNode find(TreeNode root,char target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }else{
            TreeNode leftNode = find(root.left, target);
            if (leftNode != null) {
                return leftNode;
            }
            TreeNode rightNode = find(root.right, target);
            if (leftNode != null) {
                return rightNode;
            }
            return null;
        }
    }
}
