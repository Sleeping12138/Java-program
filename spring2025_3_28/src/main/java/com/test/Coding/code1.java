package com.test.Coding;

public class code1 {
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

    public int ret = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ret;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        if (Math.floor(sum / count) == root.val) ret++;
        return new int[]{sum, count};
    }
}
