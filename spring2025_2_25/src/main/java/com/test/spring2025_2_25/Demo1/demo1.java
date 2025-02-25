package com.test.spring2025_2_25.Demo1;

import java.util.Arrays;

public class demo1 {
    public static void main(String[] args) {

    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int len = potions.length, n = spells.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            double target = success / spells[i];
            ret[i] = len - find(potions, target) + 1;
        }
        return ret;
    }

    public int find(int[] array, double target) {
        int n = array.length, left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
