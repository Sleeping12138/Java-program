package Demo1;

import java.util.Arrays;

public class MyBitSet {
    private byte[] array;
    public int useSize;

    public MyBitSet() {
        this.array = new byte[1];
    }

    public MyBitSet(int val) {
        this.array = new byte[val / 8 + 1];
    }

    //设置 - set
    public void set(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("数据越剧");
        }
        int arrayIndex = val / 8;
        int bitIndex = val % 8;
        //扩容
        if (arrayIndex + 1 > array.length) {
            array = Arrays.copyOf(array, arrayIndex + 1);
        }
        array[arrayIndex] |= (1 << bitIndex);
        useSize++;
    }

    //判断是否存在 - get
    public boolean get(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("数据越剧");
        }
        int arrayIndex = val / 8;
        int bitIndex = val % 8;
        if ((array[arrayIndex] & (1 << bitIndex)) != 0) {
            return true;
        }
        return false;
    }

    //重置 - reSet
    public void reSet(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("数据越剧");
        }
        int arrayIndex = val / 8;
        int bitIndex = val % 8;
        array[arrayIndex] &= ~(1 << bitIndex);
        useSize--;
    }

    //返回存储数据的个数
    public int getUseSize() {
        return this.useSize;
    }

    //顺序遍历
    public void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((array[i] & (1 << j)) != 0) {
                    System.out.print((j + 8 * i) + " ");
                }
            }
        }
    }
}
