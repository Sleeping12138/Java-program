package Demo2;

public class AVLTree {
    public static class AVLTreeNode {
        public int val;
        public AVLTreeNode left;
        public AVLTreeNode right;
        public AVLTreeNode parent;
        public int bf;

        public AVLTreeNode(int val) {
            this.val = val;
        }
    }

    public AVLTreeNode root;

    //插入节点
    public void insertAVLTreeNode(int val) {
        //插入节点
        AVLTreeNode node = new AVLTreeNode(val);
        if (root == null) {
            root = node;
            return;
        }
        AVLTreeNode prev = null;
        AVLTreeNode cur = root;
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
        if (prev.val < val) {
            prev.right = node;
        } else {
            prev.left = node;
        }

        cur = node;
        AVLTreeNode parent = cur.parent;

        //修改平衡因子 + 检查是否满足AVL树的定义
        while (parent != null) {
            if (parent.left == node) {
                parent.bf--;
            } else {
                parent.bf++;
            }

            if (parent.bf == 0) {
                return;
            } else if (parent.bf == 1 || parent.bf == -1) {
                cur = parent;
                parent = cur.parent;
            } else {
                if (parent.bf == 2) {
                    if (cur.bf == 1) {
                        rotateLeft(parent);
                    } else {
                        rotateRL(parent);
                    }
                } else {
                    //parent.bf == -2
                    if (cur.bf == -1) {
                        rotateRight(parent);
                    } else {
                        rotateLR(parent);
                    }
                }
            }
        }
    }

    //左右双旋
    private void rotateLR(AVLTreeNode parent) {
        AVLTreeNode subL = parent.left;
        AVLTreeNode subLR = subL.right;
        int valBF = subLR.bf;

        rotateLeft(subL);
        rotateRight(parent);

        if (valBF == -1) {
            parent.bf = 1;
            subLR.val = 0;
            subL.val = 0;
        } else if (valBF == 1) {
            subL.bf = -1;
            parent.bf = 0;
            subLR.bf = 0;
        }
    }

    //右左双旋
    private void rotateRL(AVLTreeNode parent) {
        AVLTreeNode subR = parent.right;
        AVLTreeNode subRL = subR.left;
        int valBF = subRL.bf;

        rotateRight(subR);
        rotateLeft(parent);

        if (valBF == -1) {
            parent.bf = 0;
            subRL.bf = 0;
            subR.bf = 1;
        } else if (valBF == 1) {
            parent.bf = -1;
            subRL.bf = 0;
            subR.bf = 0;
        }
    }

    //右单旋
    private void rotateRight(AVLTreeNode parent) {
        AVLTreeNode subL = parent.left;
        AVLTreeNode subLR = subL.right;

        parent.left = subLR;
        subL.right = parent;
        if (subLR != null) {
            subLR.parent = parent;
        }
        AVLTreeNode parParent = parent.parent;
        parent.parent = subL;

        if (parent == root) {
            root = subL;
            subL.parent = null;
        } else {
            if (parParent.left == parent) {
                parParent.left = subL;
            } else {
                parParent.right = subL;
            }
            subL.parent = parParent;
        }

        subL.bf = parent.bf = 0;
    }

    //左单旋
    private void rotateLeft(AVLTreeNode parent) {
        AVLTreeNode subR = parent.right;
        AVLTreeNode subRL = subR.left;

        parent.right = subRL;
        subR.left = parent;
        if (subRL != null) {
            subRL.parent = parent;
        }
        AVLTreeNode parParent = parent.parent;
        parent.parent = subR;

        if (parParent == root) {
            root = subR;
            subR.parent = null;
        } else {
            if (parParent.left == parent) {
                parParent.left = subR;
            } else {
                parParent.right = subR;
            }
            subR.parent = parParent;
        }

        parent.bf = subR.bf = 0;
    }
}
