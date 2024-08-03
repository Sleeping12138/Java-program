package Demo1;

public class BinarySearchTree {
    //二叉搜索树节点的定义
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;


    //插入节点
    public void insertNode(int val) {
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
            } else {
                prev = cur;
                cur = cur.left;
            }
        }
        if (prev.val < val) {
            prev.right = new TreeNode(val);
        }else {
            prev.left = new TreeNode(val);
        }
    }

    //查找节点
    public TreeNode findNode(int val) {
        TreeNode cur = root;
        while (root != null) {
            if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val>val) {
               cur = cur.left;
            }else {
                return cur;
            }
        }
        return null;
    }

    //删除节点
    public void remove(int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val>val) {
                parent = cur;
                cur = cur.left;
            }else{
                removeNode(parent,cur);
                return;
            }
        }
    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.left == null) {
            if(cur == root){
                root = cur.right;
            }else {
                if (parent.left == cur) {
                    parent.left = cur.right;
                }else {
                    parent.right = cur.right;
                }
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }else{
                if (parent.left == cur) {
                    parent.left = cur.left;
                }else{
                    parent.right = cur.left;
                }
            }
        }else{
            TreeNode targetParent = cur;
            TreeNode target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (targetParent.left == target) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }


}
