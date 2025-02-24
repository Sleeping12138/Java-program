package Demo1;

import java.util.HashMap;
import java.util.Map;

public class demo1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表来存储数值及其对应的下标
        Map<Integer, Integer> idx = new HashMap<>();

        // 先将所有数及其下标都加到哈希表中
        for (int j = 0; j < nums.length; j++) {
            idx.put(nums[j], j);  // 直接覆盖，相同元素的下标取最靠右的
        }

        // 再次遍历数组，寻找满足条件的两个数
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            // 如果当前元素是最后一个，删除它
            if (idx.get(x) == i) {
                idx.remove(x);
            }

            // 在哈希表中查找是否存在满足条件的另一个数
            if (idx.containsKey(target - x)) {
                return new int[]{i, idx.get(target - x)};
            }
        }

        // 如果没有找到，返回空数组（根据题目描述，这种情况不会发生）
        return new int[0];
    }
}
