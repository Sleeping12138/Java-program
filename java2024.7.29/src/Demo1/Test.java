package Demo1;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate(array, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.get(nums[i]) == null) {
                map.put(nums[i], i);
            } else if(i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
