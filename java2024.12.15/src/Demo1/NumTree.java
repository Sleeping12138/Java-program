package Demo1;

// 树状数组
public class NumTree {
    // 存储原始数据的数组
    public int[] array;

    // 存储关键区间
    public int[] tree;

    public NumTree(int[] nums) {
        int n = nums.length;
        array = new int[n];
        tree = new int[n];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    // 对数组中的一段数据进行求和
    public void update(int index, int val) {
        int delta = val - array[index];
        array[index] = val;
        for (int i = index + 1; i < tree.length; i += i & -i) {
            tree[i] += delta;
        }
    }

    public int sumNum(int index) {
        int sum = 0;
        for (; index > 0; index -= index & -index) {
            sum += tree[index];
        }
        return sum;
    }

    // 对数组中的一段数据进行求和
    public int prefixSum(int index1, int index2) {
        return sumNum(index2 + 1) - sumNum(index1);
    }
}
