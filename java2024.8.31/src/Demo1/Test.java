package Demo1;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        System.out.println(4 % 5);

        //正负数取余法则统一
        System.out.println((-1 % 5 + 5) % 5);


    }

    public static void sortColors(int[] nums) {
        // 数组分三区
        int left = -1, cur = 0, right = nums.length;
        while (cur < right) {
            if (nums[cur] == 0)
                swap(nums, ++left, cur++);
            else if (nums[cur] == 1)
                cur++;
            else
                swap(nums, --right, cur);
        }
    }

    public static void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    public static int findKthLargest(int[] nums, int k) {
        return findKthLargestChild(nums, 0, nums.length - 1, k);
    }

    public static int findKthLargestChild(int[] nums, int left, int right, int k) {
        int key = nums[new Random().nextInt(right - left + 1) + left];
        int l = left - 1;
        int r = right + 1;
        int cur = left;
        while (cur < r) {
            if (nums[cur] < key)
                swap(nums, ++l, cur++);
            else if (nums[cur] == key)
                cur++;
            else
                swap(nums, --r, cur);
        }

        int c = right - r + 1, b = r - l - 1;
        if (c >= k)
            return findKthLargestChild(nums, r, right, k);
        else if (c + b >= k)
            return key;
        else
            return findKthLargestChild(nums, left, l, k - c - b);
    }

}
