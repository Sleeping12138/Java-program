package com.ojtest.demo;

import java.util.Arrays;
import java.util.HashSet;

public class code1 {
    public static void main(String[] args) {
        int[] array = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(array, 9)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num))
                return new int[] { target - num, num };
            set.add(num);
        }
        return null;
    }
}
