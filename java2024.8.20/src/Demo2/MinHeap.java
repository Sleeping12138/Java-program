package Demo2;

import java.util.Arrays;

//堆的创建与使用
public class MinHeap {
    private int[] element;
    private int usedSize;

    public MinHeap(int capacity) {
        element = new int[capacity];
    }

    //堆的创建 - 批量创建
    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            element[i] = array[i];
            usedSize++;
        }
        //从最后一个父节点开始
        for (int parent = (usedSize - 1 - 1 / 2); parent >= 0; parent--) {
            //逐个创建小根堆
            shiftDown(parent, usedSize);
        }
    }

    private void shiftDown(int parent, int usedSize) {
        int child = 2 * parent + 1;
        if (child + 1 < usedSize && element[child + 1] < element[child]) {
            child++;
        }
        while (child < usedSize) {
            if (element[parent] < element[child]) {
                break;
            } else {
                swap(parent, child);
                parent = child;
                child = 2 * parent + 1;
            }
        }
    }

    private void swap(int pos1, int pos2) {
        int temp = element[pos1];
        element[pos1] = element[pos2];
        element[pos2] = temp;
    }

    //使用逐个插入的方式创建小根堆
    public void insertHeap(int val) {
        if (isFull(element)) {
            element = Arrays.copyOf(element, 2 * element.length);
        }
        insert(val);
    }

    //插入操作
    public void insert(int val) {
        if(isFull(element)){
            element = Arrays.copyOf(element, 2 * element.length);
        }
        element[usedSize] = val;
        shiftUp(usedSize);
        usedSize++;
    }

    //向上调整算法
    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (parent >= 0) {
            if (element[parent] > element[child]) {
                swap(parent, child);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    private boolean isFull(int[] array) {
        return element.length == usedSize;
    }

    //删除操作
    public void delete() {
        swap(0, usedSize - 1);
        usedSize--;
        shiftDown(0, usedSize);
    }

    //返回堆顶元素
    public int HeapTop() {
        if (isEmpty()) {
            throw new HeapIsNullException("堆为空 !");
        }
        return element[0];
    }

    //判断堆是否为空
    public boolean isEmpty() {
        return usedSize == 0;
    }

    public void print() {
        for (int i = 0; i < element.length; i++) {
            System.out.print(element[i] + " ");
        }
    }
}
