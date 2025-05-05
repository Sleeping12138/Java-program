package Demo;

import java.util.Arrays;

public class code3 {
    public static void main(String[] args) {

    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ret = 1;
        for (int i = 1; i < n; i++) {
            int temp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    temp = Math.max(temp, dp[j] + 1);
            }
            dp[i] = temp;
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
