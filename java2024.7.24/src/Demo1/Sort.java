package Demo1;

public class Sort {
    //归并排序 - 递归形式
    public void mergeSort(int[] array) {
        mergeInsertSort(array, 0, array.length - 1);
    }

    private void mergeInsertSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeInsertSort(array, left, mid);
        mergeInsertSort(array, mid + 1, right);

        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int rightBegin = mid + 1;
        int leftBegin = left;
        int i = 0;
        int[] ret = new int[right - left + 1];
        while (left <= mid && rightBegin <= right) {
            if (array[left] < array[rightBegin]) {
                ret[i++] = array[left++];
            } else {
                ret[i++] = array[rightBegin++];
            }
        }
        while (left <= mid) {
            ret[i++] = array[left++];
        }
        while (rightBegin <= right) {
            ret[i++] = array[rightBegin++];
        }
        for (int j = 0; j < ret.length; j++) {
            array[j + leftBegin] = ret[j];
        }
    }

    public void mergeSortNo(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            for (int i = 0; i < array.length; i += 2 * gap) {
                int left = i;
                int mid = left + gap - 1;
                //mid 和 right 的范围可能超出数组长度
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                int right = mid + gap;
                if (right >= array.length) {
                    right = array.length - 1;
                }
                merge(array, left, mid, right);
            }
            gap *= 2;
        }
    }

    public void countSort(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }
        int arrayIndex = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                array[arrayIndex++] = i + min;
                count[i]--;
            }
        }
    }


//private void mergeInsertSort(int[] array, int left, int right) {
//    if (left >= right) {
//        return;
//    }
//    int mid = (left + right) / 2;
//    mergeInsertSort(array, left, mid);
//    mergeInsertSort(array, mid + 1, right);
//
//    merge(array, left, mid, right);
//}
//
//    private void merge(int[] array, int left, int mid, int right) {
//        int rightBegin = mid + 1;
//        int leftBegin = left;
//        int i = 0;
//        int[] ret = new int[right - left + 1];
//
//        // 归并两个子数组
//        while (leftBegin <= mid && rightBegin <= right) {
//            if (array[leftBegin] < array[rightBegin]) {
//                ret[i++] = array[leftBegin++];
//            } else {
//                ret[i++] = array[rightBegin++];
//            }
//        }
//
//        // 复制剩余的左半部分
//        while (leftBegin <= mid) {
//            ret[i++] = array[leftBegin++];
//        }
//
//        // 复制剩余的右半部分
//        while (rightBegin <= right) {
//            ret[i++] = array[rightBegin++];
//        }
//
//        // 将临时数组复制回原数组
//        for (int j = 0; j < ret.length; j++) {
//            array[left + j] = ret[j];
//        }
//    }
//


    //快速排序
    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        if (right - left + 1 <= 3) {
            insertSort(array, left, right);
            //计算完结果之后直接返回，否则将会做下面的无用操作
            return;
        }
        int mid = findMiddleNumber(array, left, right);

        swap(array, left, mid);
        int pivot = quickInsertSort(array, left, right);
        quickSort(array,left,pivot-1);
        quickSort(array,pivot+1,right);
    }

    private int quickInsertSort(int[] array, int left, int right) {
        int temp = array[left];
        int keyi = left;
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            while (left < right && array[left] <= temp) {
                left++;
            }
            swap(array,left,right);
        }
        swap(array, keyi, left);
        return left;
    }

    private void swap(int[] array, int left, int mid) {
        int temp = array[left];
        array[left] = array[mid];
        array[mid] = temp;
    }

    private int findMiddleNumber(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (array[left] > array[right]) {
            if (array[mid] > array[left]) {
                return left;
            } else if (array[right] > array[mid]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (array[left] > array[mid]) {
                return left;
            } else if (array[mid] > array[right]) {
                return right;
            } else {
                return mid;
            }
        }
    }

    private void insertSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= left; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }
}
