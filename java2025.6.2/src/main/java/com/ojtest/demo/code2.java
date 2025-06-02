package com.ojtest.demo;

import java.util.ArrayDeque;
import java.util.Deque;

class code2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i - deque.peekFirst() >= k) deque.pollFirst();
            if (i >= k - 1) ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
