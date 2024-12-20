package Demo1;

public class MyBitSet {

    private byte[] elem;
    private int usedSize;

    // 构造函数，初始化位图大小
    public MyBitSet(int n) {
        elem = new byte[n / 8 + 1]; // 位图大小：n个比特位
    }

    // 设置某一位为1，表示对应的值存在
    public void set(int val) {
        int arrayIndex = val / 8;
        int bitIndex = val % 8;
        elem[arrayIndex] |= (1 << bitIndex);
        usedSize++;
    }

    // 检查某个值是否存在
    public boolean get(int val) {
        int arrayIndex = val / 8;
        int bitIndex = val % 8;
        return (elem[arrayIndex] & (1 << bitIndex)) != 0;
    }

    // 重置某一位为0，表示对应的值不存在
    public void reSet(int val) {
        int arrayIndex = val / 8;
        int bitIndex = val % 8;
        elem[arrayIndex] &= ~(1 << bitIndex);
        usedSize--;
    }

    // 获取已使用的比特位数量
    public int getUsedSize() {
        return usedSize;
    }
}
