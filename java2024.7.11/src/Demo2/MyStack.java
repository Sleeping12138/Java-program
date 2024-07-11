package Demo2;

import java.util.Arrays;

//数组栈
public class MyStack {
    private int[] stackArray;
    private int useSize;

    MyStack() {
        this.stackArray = new int[10];
        this.useSize = 0;
    }

    //入栈
    public void push(int number) {
        if (isFull()) {
            bigArray();
        }
        stackArray[useSize++] = number;
    }

    private boolean isFull() {
        return this.useSize == stackArray.length;
    }

    private void bigArray() {
        this.stackArray = Arrays.copyOf(stackArray, 2 * stackArray.length);
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new StackIsEmptyException("栈中无元素！！！");
        }
        useSize--;
        return stackArray[useSize];
    }

    //返回栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new StackIsEmptyException("栈中无元素！！！");
        }
        return this.stackArray[useSize - 1];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return this.useSize == 0;
    }

    //返回栈中的元素个数
    public int size() {
        return useSize;
    }

    //打印栈中的所有元素
    public void printStack() {
        for (int i = this.size(); i >= 0; i--) {
            System.out.print(this.stackArray[i] + " ");
        }
        System.out.println();
    }

}
