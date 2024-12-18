package Demo1;

public class demo8 {
    public void mergeSort(int[] array) {
        // 调用归并排序的递归方法，排序整个数组
        mergeInsertSort(array, 0, array.length - 1);
    }

    public void mergeInsertSort(int[] array, int left, int right) {
        // 如果子数组只有一个元素或为空，则返回（递归终止条件）
        if (left >= right) {
            return;
        }

        // 计算中间位置，将数组分成两部分
        int mid = (left + right) / 2;

        // 对左半部分进行递归排序
        mergeInsertSort(array, left, mid);

        // 对右半部分进行递归排序
        mergeInsertSort(array, mid + 1, right);

        // 合并两个已排序的子数组
        merge(array, left, mid, right);
    }

    public void merge(int[] array, int left, int mid, int right) {
        // 右半部分的起始位置
        int rightBegin = mid + 1;

        // 左半部分的起始位置
        int leftBegin = left;

        // 用于存放合并结果的临时数组
        int i = 0;
        int[] ret = new int[right - left + 1];

        // 合并两个已排序的子数组
        while (left <= mid && rightBegin <= right) {
            // 比较左右两部分的元素，将较小的元素放入临时数组
            if (array[left] < array[rightBegin]) {
                ret[i++] = array[left++];
            } else {
                ret[i++] = array[rightBegin++];
            }
        }

        // 将左半部分剩余的元素添加到临时数组中
        while (left <= mid) {
            ret[i++] = array[left++];
        }

        // 将右半部分剩余的元素添加到临时数组中
        while (rightBegin <= right) {
            ret[i++] = array[rightBegin++];
        }

        // 将临时数组中的元素复制回原数组的相应位置
        for (int j = 0; j < ret.length; j++) {
            array[j + leftBegin] = ret[j];
        }
    }
}
