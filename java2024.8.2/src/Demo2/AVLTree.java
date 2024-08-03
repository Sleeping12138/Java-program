package Demo2;

public class AVLTree {
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
        prev = cur.parent;

        while (prev != null) {
            if (prev.left == cur) {
                prev.bf--;
            } else {
                prev.bf++;
            }
            if (prev.bf == 0) {
                return;
            } else if (prev.bf == -1 || prev.bf == 1) {
                cur = prev;
                prev = cur.parent;
            } else {
                //bf == 2 / -2;
                if (prev.bf == 2) {
                    if (cur.val == 1) {
                        rotateLeft(prev);
                    } else {
                        rotateRL(prev);
                    }
                } else {
                    if (cur.val == -1) {
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
        int num = subLR.bf;

        rotateLeft(subL);
        rotateRight(subLR);

        if (num == 1) {
            subL.bf = -1;
            prev.bf = subLR.bf = 0;
        } else if (num == -1) {
            prev.bf = 1;
            subLR.bf = subL.bf = 0;
        }
    }

    private void rotateRL(TreeNode prev) {
        TreeNode subR = prev.right;
        TreeNode subRl = subR.left;
        int num = subRl.bf;

        rotateRight(subR);
        rotateLeft(subRl);

        if (num == 1) {
            prev.bf = -1;
            subRl.bf = subR.bf = 0;
        } else if (num == -1) {
            subR.bf = 1;
            prev.bf = subRl.bf = 0;
        }
        //如果为0，则上边的代码已经将其全部转为0;
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
        prev.bf = subL.bf = 0;
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
        prev.bf = subR.bf = 0;
    }

    //中序遍历
    public void inorder(TreeNode root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    //判断一棵树是否为AVL树
    public boolean isAVLTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        //由于bf是自己进行计算的，如果计算错误则也不为AVL树
        if (right - left != root.bf) {
            return false;
        }

        return Math.abs(right - left) <= 1 && isAVLTree(root.left)
                && isAVLTree(root.right);
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
