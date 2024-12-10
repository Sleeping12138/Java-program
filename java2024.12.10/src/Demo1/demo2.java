package Demo1;

import java.util.ArrayDeque;
import java.util.Deque;

class demo2 {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, left = 0, maxLen = 0;
        Deque<Integer> queueMax = new ArrayDeque<>();
        Deque<Integer> queueMin = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int now = nums[i];
            while (!queueMax.isEmpty() && now > queueMax.peekLast()) {
                queueMax.pollLast();
            }
            queueMax.offerLast(now);

            while (!queueMin.isEmpty() && now < queueMin.peekLast()) {
                queueMin.pollLast();
            }
            queueMin.offerLast(now);

            while (!queueMax.isEmpty() && !queueMin.isEmpty() && Math.abs(queueMax.peekFirst() - queueMin.peekFirst()) > limit) {
                if (queueMax.peekFirst() == nums[left]) queueMax.pollFirst();
                if (queueMin.peekFirst() == nums[left]) queueMin.pollFirst();
                left++;
            }

            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}