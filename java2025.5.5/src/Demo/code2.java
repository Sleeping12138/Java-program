package Demo;

import java.util.Arrays;

public class code2 {
    public static void main(String[] args) {

    }

    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] top = new int[n];
        int[] bottom = new int[n];
        Arrays.fill(top, 1);
        Arrays.fill(bottom, 1);

        int ret = 1;
        for (int i = 1; i < n; i++) {
            int t1 = 1, t2 = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    t1 = Math.max(t1, bottom[j] + 1);
                } else if (nums[i] < nums[j]) {
                    t2 = Math.max(t2, top[j] + 1);
                }
            }
            top[i] = t1;
            bottom[i] = t2;
            ret = Math.max(Math.max(t1, t2), ret);
        }
        return ret;
    }
}
