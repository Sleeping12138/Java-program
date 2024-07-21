package Demo1;

import java.util.Arrays;

//堆的自我实现 - 创建堆 + 插入数据 + 删除数据 + 返回堆顶元素 + 判断是否为空
public class MyHeap {
    public int[] elem;
    public int useSize;

    //初始化
    public MyHeap(int[] array) {
        elem = new int[11];
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            useSize++;
        }
    }

    //整体创建堆
    public void makeBigHeap(int[] array, int useSize) {
        //使用向上调整算法
        for (int parent = (useSize - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(parent, useSize);
        }
    }

    private void shiftDown(int root, int useSize) {
        int child = 2 * root + 1;
        while (child < useSize) {
            if (child + 1 < useSize && elem[child] < elem[child + 1]) {
                child++;
            }
            if (elem[root] < elem[child]) {
                swap(root, child);
                root = child;
                child = 2 * root + 1;
            } else {
                break;
            }
        }
    }

    public void makeSmallHeap(int[] array, int useSize) {
        //使用向上调整算法
        for (int parent = (useSize - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown2(parent, useSize);
        }
    }

    private void shiftDown2(int root, int useSize) {
        int child = 2 * root + 1;
        while (child < useSize) {
            if (child + 1 < useSize && elem[child] > elem[child + 1]) {
                child++;
            }
            if (elem[root] > elem[child]) {
                swap(root, child);
                root = child;
                child = 2 * root + 1;
            } else {
                break;
            }
        }
    }

    //在堆中插入元素
    public void offerBig(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[useSize] = val;
        shiftUp(useSize);
        useSize++;
    }

    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            if (elem[parent] < elem[child]) {
                swap(parent, child);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void offerSmall(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[useSize] = val;
        shiftUp(useSize);
        useSize++;
    }

    private void shiftUp2(int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            if (elem[parent] > elem[child]) {
                swap(parent, child);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    //删除堆中元素
    public void pollBig(){
        swap(0,useSize - 1);
        useSize--;
        shiftDown(0,useSize);
    }

    public void pollSmall(){
        swap(0,useSize - 1);
        useSize--;
        shiftDown2(0,useSize);
    }

    //获取堆顶元素
    public int peek(){
        if (isEmpty()) {
            throw new ElementIsEmptyException("堆中元素已空！！！");
        }
        return elem[0];
    }

    //判断堆是否为空
    private boolean isEmpty(){
        return useSize == 0;
    }



    private boolean isFull() {
        return useSize == elem.length;
    }

    private void swap(int pos1, int pos2) {
        int temp = elem[pos1];
        elem[pos1] = elem[pos2];
        elem[pos2] = temp;
    }

    //遍历堆
    public void printHeap() {
        for (int i = 0; i < useSize; i++) {
            System.out.print(elem[i] + " ");
        }
    }
}
