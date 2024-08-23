package Demo3;

import java.util.Comparator;

//红黑树的实现
public class RBTree {
    //节点的定义
    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int val;
        public Color color;

        public TreeNode(int val) {
            this.val = val;
            color = Color.RED;
        }
    }

    public TreeNode root;

    //插入操作
    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            root.color = Color.BLACK;
            return;
        }
        TreeNode prev = null;
        TreeNode cur = root;

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
        if (prev.val < val) {
            prev.right = node;
        } else {
            prev.left = node;
        }

        //使插入节点之后的红黑树满足限制
        cur = node;
        TreeNode parent = cur.parent;
        while (parent != null && parent.color == Color.RED) {
            TreeNode grandParent = parent.parent;
            if (grandParent.left == parent) {
                TreeNode uncle = grandParent.right;
                if (uncle != null && uncle.color == Color.RED) {
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    grandParent.color = Color.RED;
                    cur = grandParent;
                    parent = cur.parent;
                } else {
                    if (parent.right == cur) {
                        rotateLeft(parent);
                        TreeNode temp = parent;
                        parent = cur;
                        cur = temp;
                    }
                    rotateRight(grandParent);
                    grandParent.color = Color.RED;
                    parent.color = Color.BLACK;
                }
            } else {
                TreeNode uncle = grandParent.left;
                if (uncle != null && uncle.color == Color.RED) {
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    grandParent.color = Color.RED;
                    cur = grandParent;
                    parent = cur.parent;
                } else {
                    if (parent.left == cur) {
                        rotateRight(parent);
                        TreeNode temp = cur;
                        cur = parent;
                        parent = temp;
                    }
                    rotateLeft(grandParent);
                    grandParent.color = Color.RED;
                    parent.color = Color.BLACK;
                }

            }
        }
        root.color = Color.BLACK;
    }

    private void rotateRight(TreeNode prev) {
        TreeNode subL = prev.left;
        TreeNode subLR = subL.right;

        prev.left = subLR;
        subL.right = prev;
        if (subLR != null) {
            subLR.parent = prev;
        }
        TreeNode parParent = prev.parent;
        prev.parent = subL;

        if (prev == root) {
            root = subL;
            subL.parent = null;
        } else {
            if (parParent.left == prev) {
                parParent.left = subL;
                subL.parent = parParent;
            } else {
                parParent.right = subL;
                subL.parent = parParent;
            }
        }
    }

    private void rotateLeft(TreeNode prev) {
        TreeNode subR = prev.right;
        TreeNode subRL = subR.left;

        subR.left = prev;
        prev.right = subRL;
        TreeNode parParent = prev.parent;
        prev.parent = subR;
        if (subRL != null) {
            subRL.parent = prev;
        }

        if (prev == root) {
            root = subR;
            subR.parent = null;
        } else {
            if (parParent.left == prev) {
                parParent.left = subR;
                subR.parent = parParent;
            } else {
                parParent.right = subR;
                subR.parent = parParent;
            }
        }
    }

    //红黑树的验证
    //判断中序遍历是否有序
    public void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    //判断是否满足红黑树的性质
    public boolean isRBTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.color != Color.BLACK) {
            return false;
        }
        int blackNumber = calBlackNumber(root);
        return examRedNode(root) && examBlackNode(root, 0, blackNumber);
    }

    private boolean examBlackNode(TreeNode root, int number, int blackNumber) {
        if (root == null) {
            return true;
        }
        if (root.color == Color.BLACK) {
            number++;
        }
        if (root.left == null && root.right == null) {
            if (number != blackNumber) {
                return false;
            }
        }
        return examBlackNode(root.left, number, blackNumber) && examBlackNode(root.right, number, blackNumber);
    }


    private boolean examRedNode(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.color == Color.RED) {
            TreeNode prev = root.parent;
            if (prev.color == Color.RED) {
                return false;
            }
        }
        return examRedNode(root.left) && examRedNode(root.right);
    }

    private int calBlackNumber(TreeNode root) {
        int num = 0;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.color == Color.BLACK) {
                num++;
            }
            cur = cur.left;
        }
        return num;
    }
}
