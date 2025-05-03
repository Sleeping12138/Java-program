package com.test.spring2025_5_3.Demo;

public class code6 {
    public static void main(String[] args) {

    }

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


    class Solution {
        public void flatten(TreeNode root) {
            if (root == null)
                return;

            flatten(root.left);
            flatten(root.right);

            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null)
                    temp = temp.right;
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }
}
