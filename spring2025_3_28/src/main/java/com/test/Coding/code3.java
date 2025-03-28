package com.test.Coding;

public class code3 {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length, max = 0;
        for (int i = 0; i < n; i++) max = Math.max(max, nums[i]);
        int[] number = new int[max + 1];
        for (int i = 0; i < n; i++) number[nums[i]] += nums[i];

        int[] f = new int[max + 1];
        int[] g = new int[max + 1];

        for (int i = 1; i < max + 1; i++) {
            f[i] = g[i - 1] + number[i];
            g[i] = Math.max(g[i - 1], f[i - 1]);
        }

        return Math.max(f[max], g[max]);
    }
}
