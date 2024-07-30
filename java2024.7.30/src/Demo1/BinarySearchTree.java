package Demo1;

public class BinarySearchTree {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode root;

    //插入节点 - 插入节点之前也要查找合适的位置
    public void insertTreeNode(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null) {
            if(cur.val<val){
                prev = cur;
                cur = cur.right;
            } else if (cur.val>val) {
                prev = cur;
                cur = cur.left;
            }else {
                return;
            }
        }
        if(prev.val<val){
            prev.right = new TreeNode(val);
        }else {
            prev.left = new TreeNode(val);
        }

    }

    //查找指定树节点
    public TreeNode findTargetTreeNode(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val) {
                cur = cur.left;
            }else if(cur.val>val){
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }
}
