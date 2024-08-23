package Demo2;

import com.sun.source.tree.Tree;

//AVL树的实现
public class AVLTree {
    //节点的定义
    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int val;
        public int bf;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.val < val) {
                prev = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                prev = cur;
                cur = cur.left;
            } else {
                return;
            }
        }
        TreeNode node = new TreeNode(val);
        if (prev.val > val) {
            prev.left = node;
        } else {
            prev.right = node;
        }

        //修改bf的值
        cur = node;
        prev = cur.parent;
        while (prev != null) {
            if (prev.bf == 0) {
                return;
            } else if (prev.bf == 1 || prev.bf == -1) {
                cur = prev;
                prev = cur.parent;
            } else {
                if (prev.bf == 2) {
                    if (cur.bf == 1) {
                        rotateLeft(prev);
                    } else {
                        rotateRL(prev);
                    }
                } else {
                    if (cur.bf == -1) {
                        rotateRight(prev);
                    } else {
                        rotateLR(prev);
                    }
                }
            }
        }
    }

    private void rotateLR(TreeNode prev) {
        TreeNode subL = prev.left;
        TreeNode subLR = subL.right;
        int number = subLR.bf;

        rotateLeft(subL);
        rotateRight(prev);

        if (number == 1) {
            subL.bf = -1;
            prev.bf = subLR.bf = 0;
        } else if (number == -1) {
            prev.bf = 1;
            subLR.bf = subL.bf = 0;
        }
    }

    private void rotateRL(TreeNode prev) {
        TreeNode subR = prev.right;
        TreeNode subRL = subR.left;
        int number = subRL.bf;

        rotateRight(subR);
        rotateLeft(prev);

        if (number == 1) {
            prev.bf = -1;
            subRL.bf = subR.bf = 0;
        } else if (number == -1) {
            subR.bf = 1;
            prev.bf = subRL.bf = 0;
        }

    }

    private void rotateRight(TreeNode prev) {
        TreeNode subL = prev.left;
        TreeNode subLR = subL.right;

        prev.left = subLR;
        subL.right = prev;
        if (subLR != null) {
            subLR.parent = prev;
        }
        prev.parent = subL;
        TreeNode parent = prev.parent;

        if (prev == root) {
            root = subL;
            subL.parent = null;
        } else {
            if (parent.left == prev) {
                parent.left = subL;
                subL.parent = parent;
            } else {
                parent.right = subL;
                subL.parent = parent;
            }
            prev.bf = subL.bf = 0;
        }
    }

    private void rotateLeft(TreeNode prev) {
        TreeNode subR = prev.right;
        TreeNode subRL = subR.left;

        subR.left = prev;
        prev.right = subRL;
        if (subRL != null) {
            subRL.parent = prev;
        }
        TreeNode parent = prev.parent;
        parent.parent = subR;
        if (prev == root) {
            root = subR;
            subR.parent = null;
        } else {
            if (parent.left == prev) {
                parent.left = subR;
                subR.parent = parent;
            } else {
                parent.right = subR;
                subR.parent = parent;
            }
        }
        parent.bf = subR.bf = 0;
    }


    //中序遍历AVL树
    public void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    public boolean isAVLTree(TreeNode root) {
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (rightHeight - leftHeight != root.bf) {
            return false;
        }
        return Math.abs(rightHeight - leftHeight) <= 1 && isAVLTree(root.left) && isAVLTree(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
