package Demo2;

import java.util.Arrays;
import java.util.Stack;

//排序算法
public class Sort {
    //直接插入排序
    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int end = i - 1;
            while (end >= 0) {
                if (array[end] > temp) {
                    array[end + 1] = array[end];
                    end--;
                } else {
                    break;
                }
            }
            array[end + 1] = temp;
        }
    }

    //希尔排序
    public void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            gap /= 2;
            shellSortChild(array, gap);
        }
    }

    private void shellSortChild(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int temp = array[gap];
            int end = i - gap;
            while (end >= 0) {
                if (array[end] > temp) {
                    array[end + gap] = array[end];
                    end -= gap;
                } else {
                    break;
                }
            }
            array[end + gap] = temp;
        }
    }

    //选择排序 - 普通版
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < array.length; k++) {
                if (array[minIndex] > array[k]) {
                    minIndex = k;
                }
            }
            swap(array, minIndex, i);
        }
    }

    private void swap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    //选择排序 - 优化版本
    public void selectSort2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = left;
            for (int i = left + 1; i < array.length; i++) {
                if (array[minIndex] > array[i]) {
                    minIndex = i;
                }
                if (array[maxIndex] < array[i]) {
                    maxIndex = i;
                }
            }
            swap(array, left, minIndex);
            if (left == maxIndex) {
                maxIndex = minIndex;
            }
            swap(array, maxIndex, right);
            left++;
            right--;
        }
    }

    //堆排序
    public void heapSort(int[] array) {
        makeBigHeap(array);

        int len = array.length - 1;
        while (len > 0) {
            swap(array, 0, len);
            shiftDown(array, 0, len);
            len--;
        }
    }

    //创建大根堆
    private void makeBigHeap(int[] array) {
        int len = array.length;
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(array, parent, len);
        }
    }

    //向下调整算法
    private void shiftDown(int[] array, int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child + 1] > array[child]) {
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
            for (int k = 0; k < array.length - 1 - i; k++) {
                if (array[k] > array[k] + 1) {
                    swap(array, k, k + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    //时间复杂度优化 - 三数取中
    public int middleIndex(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (array[left] < array[mid]) {
            if (array[mid] < array[right]) {
                return mid;
            } else if (array[right] < array[left]) {
                return left;
            } else {
                return right;
            }
        } else {
            if (array[right] > array[left]) {
                return right;
            } else if (array[right] < array[mid]) {
                return mid;
            } else {
                return left;
            }
        }
    }

    public void insertOfQuickSort(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = array[i];
            int end = i - 1;
            while (end >= 0) {
                if (array[end] > temp) {
                    array[end + 1] = array[end];
                    end--;
                } else {
                    break;
                }
            }
            array[end + 1] = temp;
        }
    }

    //快速排序 - hoare法
    public void quickSort(int[] array) {
        int len = array.length;
        quickSortChild(array, 0, len);
    }

    private void quickSortChild(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        //优化空间复杂度
        if (right - left <= 10) {
            insertOfQuickSort(array, left, right);
            return;
        }
        int index = quickHoare(array, left, right);
        quickSortChild(array, left, index - 1);
        quickSortChild(array, index + 1, right);
    }

    private int quickHoare(int[] array, int left, int right) {
        int mid = middleIndex(array, left, right);
        swap(array, left, mid);
        int target = array[left];
        int targetIndex = left;
        while (left < right) {
            while (left < right && array[right] >= target) {
                right--;
            }
            while (left < right && array[left] <= target) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, targetIndex, left);
        return left;
    }

    //快速排序 - 前后指针法
    public void quickSort1(int[] array) {
        int len = array.length;
        quickSort1Child(array, 0, len);
    }

    private void quickSort1Child(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = quickSortWa(array, left, right);
        quickSort1Child(array, left, index - 1);
        quickSort1Child(array, index + 1, right);
    }

    private int quickSortWa(int[] array, int left, int right) {
        int target = array[left];
        while (left < right) {
            while (left < right && array[right] >= target) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= target) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = target;
        return left;
    }

    //快速排序 - 前后指针
    public void quickSort2(int[] array) {
        int end = array.length - 1;
        quickSortQChild(array, 0, end);
    }

    private void quickSortQChild(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int target = quickSortQ(array, left, right);
        quickSortQChild(array, left, target - 1);
        quickSortQChild(array, target + 1, right);
    }

    private int quickSortQ(int[] array, int left, int right) {
        int prev = left;
        int cur = left + 1;
        int temp = array[left];
        while (cur < right) {
            if (array[cur] < temp) {
                prev++;
                swap(array, prev, cur);
            }
            cur++;
        }
        swap(array, left, prev);
        return prev;
    }

    //快速排序的非递归形式
    public void quickSortNor(int[] array) {
        quickSortNorChild(array, 0, array.length - 1);
    }

    private void quickSortNorChild(int[] array, int left, int rigth) {
        int pivot = quickHoare(array, left, rigth);
        Stack<Integer> stack = new Stack<>();
        if (pivot - 1 > left) {
            stack.push(left);
            stack.push(pivot-1);
        }
        if (pivot + 1 < rigth) {
            stack.push(pivot+1);
            stack.push(rigth);
        }

        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            pivot = quickHoare(array, start, end);
            if (pivot - 1 > start) {
                stack.push(start);
                stack.push(pivot-1);
            }
            if (pivot + 1 < end) {
                stack.push(pivot+1);
                stack.push(end);
            }
        }
    }

    //归并排序 - 非递归形式
    public void mergeSort(int[] array){
        mergeSortChild(array,0,array.length-1);
    }

    private void mergeSortChild(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left+right)/2;
        mergeSortChild(array, left, mid);
        mergeSortChild(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftBegin = left;
        int rightBegin = mid+1;
        int[] ret = new int[right - left + 1];
        int i =0;
        while (left <= mid && rightBegin <= right) {
            if (array[left] < array[rightBegin]) {
                ret[i++] = array[left++];
            }else {
                ret[i++] = array[rightBegin++];
            }
        }
        while(left <= mid){
            ret[i++] = array[left++];
        }
        while(rightBegin <= right){
            ret[i++] = array[rightBegin++];
        }

        for (int j = 0; j < ret.length; j++) {
            array[j+leftBegin] = ret[j];
        }
    }

    //归并排序 - 非递归形式
    public void mergeSortNor(int[] array){
        int gap = 1;
        while (gap < array.length) {
            for (int i = 0; i < array.length; i += 2 * gap) {
                int left = i;
                int mid = i+gap-1;
                if (mid >= array.length) {
                    mid = array.length-1;
                }
                int right = mid+gap;
                if (right >= array.length) {
                    right = array.length-1;
                }
                merge(array,left,mid,right);
            }
            gap*=2;
        }
    }

    //计数排序
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
            count[array[i]-min]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                array[index++] = i + min;
                count[i]--;
            }
        }
    }
}
