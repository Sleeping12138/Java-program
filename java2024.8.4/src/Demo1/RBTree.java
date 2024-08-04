package Demo1;

//红黑树
public class RBTree {
    //红黑树节点的定义
    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int val;
        public Color color;

        public TreeNode(int val) {
            this.val = val;
            this.color = Color.RED;
        }
    }

    public TreeNode root;

    //红黑树中节点的插入
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
                    parent.color = Color.BLACK;
                    grandParent.color = Color.RED;
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
                        TreeNode temp = parent;
                        parent = cur;
                        cur = temp;
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

    //判断一棵树是否为红黑树
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    /*
    根节点不能是红色的
    不能有两个连续的红色节点
    每条路径上的黑色节点个数相同
    * */

    public boolean isRBTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.color == Color.RED) {
            return false;
        }

        int prevBlackNodeNum = calBlackNumber(root);

        return examRedNode(root) && examBlackNode(root, 0, prevBlackNodeNum);
    }

    private int calBlackNumber(TreeNode root) {
        int prevBlackNodeNum = 0;
        TreeNode cur = root;
        while (cur.left != null) {
            if (cur.color == Color.BLACK) {
                prevBlackNodeNum++;
            }
            cur = cur.left;
        }
        return prevBlackNodeNum;
    }

    //红色节点不能连续
    private boolean examRedNode(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.color == Color.RED) {
            TreeNode parent = root.parent;
            if (parent.color == Color.RED) {
                return false;
            }
        }
        return examRedNode(root.left) && examRedNode(root.right);
    }

    //每条路径上的黑色节点个数相同
    private boolean examBlackNode(TreeNode root, int blackNodeNum, int prevBlackNodeNum) {
        if (root == null) {
            return true;
        }
        if (root.color == Color.BLACK) {
            blackNodeNum++;
        }
        if (root.left == null && root.right == null) {
            if (blackNodeNum != prevBlackNodeNum) {
                return false;
            }
        }
        return examBlackNode(root.left, blackNodeNum, prevBlackNodeNum)
                && examBlackNode(root.right, blackNodeNum, prevBlackNodeNum);
    }
}
