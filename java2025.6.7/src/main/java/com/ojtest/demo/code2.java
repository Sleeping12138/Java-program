package com.ojtest.demo;

import java.util.ArrayList;
import java.util.List;

public class code2 {
    public static void main(String[] args) {

    }

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        dfs(nums, 0);
        return list;
    }

    public void dfs(int[] nums, int index) {
        list.add(new ArrayList<>(path));
        for (int i = index; i < n; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
