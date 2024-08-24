package Demo1;

import java.util.Arrays;

//位图的自我实现
public class MyBitSet {
    public byte[] array;
    public int usedSize;

    public MyBitSet() {
        this.array = new byte[1];
    }

    public MyBitSet(int val) {
        this.array = new byte[val / 8 + 1];
    }

    //载入数据
    public void set(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("数据异常！！！");
        }
        int byteIndex = val / 8;
        int bitIndex = val % 8;
        if (byteIndex + 1 > array.length) {
            array = Arrays.copyOf(array, byteIndex + 1);
        }
        array[byteIndex] |= (1 << bitIndex);
        usedSize++;
    }

    //判断位图中是否有该数据
    public boolean get(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("数据异常！！！");
        }
        int byteIndex = val / 8;
        int bitIndex = val % 8;
        if (byteIndex + 1 > array.length) {
            array = Arrays.copyOf(array, byteIndex + 1);
        }
        if ((array[byteIndex] & (1 << bitIndex)) != 0) {
            return true;
        }
        return false;
    }

    //重置某一数据
    public void reSet(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("数据异常！！！");
        }
        int byteIndex = val / 8;
        int bitIndex = val % 8;
        if (byteIndex + 1 > array.length) {
            array = Arrays.copyOf(array, byteIndex + 1);
        }
        array[byteIndex] &= (~(1 << bitIndex));
        usedSize--;
    }

    //获取位图中数据个数
    public int getUsedSize() {
        return this.usedSize;
    }

    //打印位图中的数据
    public void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((array[i] & (1 << j)) != 0) {
                    System.out.print(8 * i + j + " ");
                }
            }
        }
    }
}
