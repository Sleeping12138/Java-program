package com.test.spring2025_5_3.Demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code5 {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if (root == null)
                return ret;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean flag = true;
                while (size-- > 0) {
                    TreeNode now = queue.poll();
                    if (flag) {
                        ret.add(now.val);
                        flag = false;
                    }
                    if (now.right != null)
                        queue.offer(now.right);
                    if (now.left != null)
                        queue.offer(now.left);
                }
            }

            return ret;
        }
    }
}
