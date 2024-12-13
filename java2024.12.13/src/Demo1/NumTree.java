package Demo1;


public class NumTree {
    // 用于存储原始数组
    public int[] array;

    // 用于存储关键区间
    public int[] tree;

    public NumTree(int[] nums) {
        int n = nums.length;
        array = new int[n];
        tree = new int[n + 1];
        // 使用update方法进行初始化，可以认为所有原始数据都从0进行修改了，进行更新关键区间
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int delta = val - array[index];
        array[index] = val;

        // 根据差值更新于index索引位置有关的关键区间的值,相关的关键区间为加上lowbit
        for (int i = index + 1; i < tree.length; i += i & -i) {
            tree[i] += delta;
        }
    }

    public int sumNum(int index) {
        int sum = 0;
        for (; index > 0; index -= index * -index) {
            sum += tree[index];
        }
        return sum;
    }

    public int prefixSum(int index1, int index2) {
        return sumNum(index2 + 1) - sumNum(index1);
    }

}
