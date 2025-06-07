package com.ojtest.demo;

import java.util.ArrayList;
import java.util.List;

public class code1 {
    public static void main(String[] args) {

    }

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] vis;
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        vis = new boolean[n];
        dfs(nums, 0);
        return list;
    }

    public void dfs(int[] nums, int index) {
        if (index == n) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                path.add(nums[i]);
                vis[i] = true;
                dfs(nums, index + 1);
                vis[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
