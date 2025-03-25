package com.test.spring2025_3_25.Demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo2 {

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

    public HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        int maxNum = 1;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(),value = entry.getValue();
            if(value==maxNum) list.add(key);
            else if(value>maxNum) {
                list.clear();
                list.add(key);
                maxNum = value;
            }
        }

        int n = list.size();
        int[] ret = new int[n];
        for(int i = 0;i<n;i++) ret[i] = list.get(i);
        return ret;
    }

    public int getSum(TreeNode root) {
        if (root == null) return 0;
        int temp = getSum(root.left) + getSum(root.right) + root.val;
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        return temp;
    }
}
