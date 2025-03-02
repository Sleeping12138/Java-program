package com.test.spring2025_3_2.Demo1;

import java.util.HashMap;

public class demo1 {
    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length, count = 0;
        map.put(0, 1);
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
            count += map.getOrDefault(sum[i + 1] - goal, 0);
            map.put(sum[i + 1], map.getOrDefault(sum[i + 1], 0) + 1);
        }
        return count;
    }
}
