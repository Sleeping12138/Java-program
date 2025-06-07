package com.ojtest.demo;

import java.util.ArrayList;
import java.util.List;

public class code3 {
    public static void main(String[] args) {

    }

    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int target, n;

    public List<List<Integer>> combinationSum(int[] candidates, int _target) {
        target = _target;
        n = candidates.length;
        dfs(candidates, 0, 0);
        return ret;
    }

    public void dfs(int[] candidates, int sum, int index) {
        if (sum > target)
            return;
        if (sum == target) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < n; i++) {
            path.add(candidates[i]);
            dfs(candidates, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
