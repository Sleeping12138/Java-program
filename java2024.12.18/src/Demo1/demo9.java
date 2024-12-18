package Demo1;

public class demo9 {
    public void countSort(int[] array) {
        // 初始化最小值和最大值为数组的第一个元素
        int min = array[0];
        int max = array[0];

        // 遍历数组，找到最小值和最大值
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 创建计数数组，用于统计每个元素出现的次数
        int[] count = new int[max - min + 1];

        // 统计数组中每个元素出现的次数
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }

        // 将排序后的元素放回原数组
        int arrayIndex = 0;
        for (int i = 0; i < count.length; i++) {
            // 对计数数组进行处理，将每个元素根据其计数放入原数组中
            while (count[i] != 0) {
                array[arrayIndex++] = i + min;
                count[i]--;
            }
        }
    }
}
