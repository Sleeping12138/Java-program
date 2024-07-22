package Demo1;

import javax.swing.*;
import java.util.IllegalFormatCodePointException;

//排序算法
public class Sort {
    //不优化情况
    //选择排序 - 选出最小或最大和首交换
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    //优化 - 一次就选出最小和最大
    public void selectSort2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = left;
            for (int j = left + 1; j <= right; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(array, left, minIndex);
            if (maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(array, right, maxIndex);
            left++;
            right--;
        }
    }

    private void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    //堆排序
    public void heapSort(int[] array) {
        //将数组转换为大根堆
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0; parent--) {
            makeHeap(array, parent, array.length);
        }

        //交换 0 和 end 反复
        int end = array.length - 1;
        while (end > 0) {
            swap(array, 0, end);
            makeHeap(array, 0, end);
            end--;
        }
    }

    private void makeHeap(int[] array, int parent, int length) {
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }
            if (array[parent] < array[child]) {
                swap(array, parent, child);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    //冒泡排序
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = false;
                    swap(array, j, j + 1);
                }
            }
            if (flag) {
                break;
            }
        }
    }

    //快速排序 - hoare
    public void quickSort(int[] array) {
        int end = array.length - 1;
        quickSortHo(array, 0, end);
    }

    private void quickSortHo(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int target = findTargetH(array, left, right);
        quickSortHo(array, left, target - 1);
        quickSortHo(array, target + 1, right);
    }

    private int findTargetH(int[] array, int left, int right) {
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

    //快速排序 - 挖坑法
    public void quickSort2(int[] array) {
        int end = array.length - 1;
        quickSortW(array, 0, end);
    }

    private void quickSortW(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int target = findTargetW(array, left, right);
        quickSortW(array, left, target - 1);
        quickSortW(array, target + 1, right);
    }

    private int findTargetW(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {
            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }

    //快速排序 - 前后指针法
    public void quickSort3(int[] array) {
        int end = array.length - 1;
        quickSortQ(array, 0, end);
    }

    private void quickSortQ(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int target = findTargetQ(array, left, right);
        quickSortQ(array, left, target - 1);
        quickSortQ(array, target + 1, right);
    }

    private int findTargetQ(int[] array, int left, int right) {
        int cur = left;
        int prev = left + 1;
        int temp = array[left];
        while (prev <= right) {
            if (array[prev] < temp && ++cur != prev) {
                swap(array, cur, prev);
            }
            prev++;
        }
        swap(array,left,cur);
        return cur;
    }
}
