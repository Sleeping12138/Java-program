package Demo1;

import java.util.Arrays;


public class MyHeap {
    //堆 - 将完全二叉树的链式结构转换为数组形式来进行存储
    int[] heap;
    int useSize;

    //数组的初始化
    public MyHeap(int[] array) {
        heap = new int[10];
        for (int i = 0; i < array.length; i++) {
            heap[i] = array[i];
            this.useSize++;
        }
    }

    //堆的创建 - 创建大根堆
    public void makeBigHeap(int[] heap, int useSize) {
        int parent = (useSize - 1 - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            shiftDown(i, useSize);
        }
    }

    public void shiftDown(int parent,int useSize) {
        int child = 2 * parent + 1;
        while (child < useSize) {
            if (child + 1 < useSize && heap[child] < heap[child + 1]) {
                child++;
            }
            if (heap[parent] < heap[child]) {
                swap(parent, child);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    //创建小根堆
    public void makeSmallHeap(int[] heap, int useSize) {
        int parent = (useSize - 1 - 1) / 2;
        for (int i = parent; i >= 0; i--) {
            shiftDown2(i, useSize);
        }
    }

    private void shiftDown2(int parent,int useSize) {
        int child = 2 * parent + 1;
        while (child < useSize) {
            if (child + 1 < useSize && heap[child] > heap[child + 1]) {
                child++;
            }
            if (heap[child] < heap[parent]) {
                swap(child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //在堆中插入元素
    public void offerBig(int number) {
        if (isFull()) {
            heap = Arrays.copyOf(heap, 2 * heap.length);
        }
        heap[useSize++] = number;
        shiftUp(useSize - 1);
    }

    public void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            if (heap[parent] < heap[child]) {
                swap(parent, child);
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public void offerSmall(int number) {
        if (isFull()) {
            heap = Arrays.copyOf(heap, 2 * heap.length);
        }
        heap[useSize++] = number;
        shiftUp2(useSize - 1);
    }

    public void shiftUp2(int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            if (heap[parent] > heap[child]) {
                swap(parent, child);
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    private boolean isFull() {
        return useSize == heap.length;
    }

    //返回堆首元素
    public int peek() {
        if (isEmpty()) {
            throw new NullElementException("堆中不存在元素!!!");
        }
        return heap[0];
    }

    //判断堆是否为空
    public boolean isEmpty() {
        return useSize == 0;
    }

    //堆排序 - 正序排序
    public void heapSort(int[] array) {
        int len = array.length;
        makeBigHeap(array, len);
        int end = len - 1;
        while (end > 0) {
            swap(0, end);
            shiftDown(0, end);
            end--;
        }
    }
}
