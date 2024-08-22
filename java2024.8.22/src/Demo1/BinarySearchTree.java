package Demo1;

import java.security.cert.TrustAnchor;

public class BinarySearchTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    //查询操作 - 通过二叉搜索树的定义遍历二叉搜索树进行查找
    public TreeNode findNode(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }

    //插入操作 - 找到合适的位置进行插入
    public void insert(int val) {
        if (root == null) {
            TreeNode newNode = new TreeNode(val);
            root = newNode;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                return;
            }
        }
        TreeNode node = new TreeNode(val);
        if (parent.val < val) {
            parent.right = node;
        } else {
            parent.left = node;
        }
    }

    //删除操作
    public void delete(int val) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            } else {
                deleteCChild(parent, cur);
                return;
            }
        }
    }

    private void deleteCChild(TreeNode parent, TreeNode cur) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            TreeNode targetParent = cur;
            TreeNode target = cur.right;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (targetParent.left == target) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }
}
