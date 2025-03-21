package Demo1;

import java.util.ArrayList;
import java.util.List;

public class demo1 {
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

        class Solution {
            public List<String> ret = new ArrayList<String>();
            public StringBuilder sb = new StringBuilder();

            public List<String> binaryTreePaths(TreeNode root) {
                dfs(root);
                return ret;
            }

            public void dfs(TreeNode root) {
                int size = sb.length();
                if (root.left == null && root.right == null) {
                    sb.append(root.val);
                    ret.add(sb.toString());
                    sb.setLength(size);
                    return;
                }

                sb.append(root.val + "->");
                if (root.left != null) {
                    dfs(root.left);
                }
                if (root.right != null) {
                    dfs(root.right);
                }
                sb.setLength(size);
            }
        }
    }
}
