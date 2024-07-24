package Demo3;

//二叉搜索树
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

    //插入节点
    public void insertNode(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        TreeNode node = new TreeNode(key);
        //寻找合适的位置插入节点
        while (cur != null) {
            if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            } else {
                return;
            }
        }
        //这样写会避免插入节点的时候左边也是null的情况
        if (parent.val>key) {
            parent.left = node;
        }else {
            parent.right = node;
        }
    }

    //搜索节点
    public TreeNode search(int key){
        TreeNode cur = root;
        while (cur!=null) {
            if (cur.val < key) {
                cur = cur.right;
            } else if (cur.val > key) {
                cur = cur.right;
            }else{
                return cur;
            }
        }
        return null;
    }

    //删除节点
    public void remove(int key) {
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < key) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            }else{
                removeNode(parent,cur);
            }
        }
    }

    private void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.right == null) {
            if (cur == root) {
                root = root.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
        } else if (cur.left == null) {
            if (cur == root) {
                root = root.right;
            }else if(parent.left == cur){
                parent.left = cur.right;
            }else{
                parent.right = cur.right;
            }
        }else {
            TreeNode targetParent = cur;
            TreeNode target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (targetParent.left == target) {
                targetParent.left = target.right;
            }else{
                targetParent.right = target.right;
            }
        }
    }
}
