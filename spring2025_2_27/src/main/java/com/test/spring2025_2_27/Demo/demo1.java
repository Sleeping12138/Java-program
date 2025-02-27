package com.test.spring2025_2_27.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {

    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> ret = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + nums[i - 1];

        for (int num : queries) {
            int index = Arrays.binarySearch(nums, num);
            if (index < 0)
                index = ~index;
            long left = (long) num * index - sum[index];
            long right = sum[n] - sum[index] - (long) (n - index) * num;
            ret.add(left + right);
        }

        return ret;
    }
}
