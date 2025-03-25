package com.test.spring2025_3_25.Demo1;

public class demo3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    public void dfs(TreeNode root) {
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            dfs(root.left);
            sb.append(")");
        }
        if (root.left == null && root.right != null)
            sb.append("()");
        if (root.right != null) {
            sb.append("(");
            dfs(root.right);
            sb.append(")");
        }
    }
}
