package Demo1;

class demo2 {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int number : nums)
            max = Math.max(max, number);

        int maxNum = 0, n = nums.length, left = 0;
        long ret = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == max)
                maxNum++;
            while (maxNum >= k) {
                ret += n - right;
                if (nums[left] == max)
                    maxNum--;
                left++;
            }
        }

        return ret;
    }
}
