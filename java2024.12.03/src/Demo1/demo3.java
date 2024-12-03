package Demo1;

class demo3 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, left = 0, sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
