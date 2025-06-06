package com.ojtest.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code2 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1, right = n - 1;
            // 优化
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) continue;
            if (nums[right] + nums[right - 1] + nums[right - 2] < 0) continue;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    ret.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    right--;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                }
            }
        }
        return ret;
    }
}
