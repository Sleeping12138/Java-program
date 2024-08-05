package Demo2;

import javax.swing.plaf.SplitPaneUI;
import java.util.BitSet;

//生成随机函数
class SimpleHash {
    //布隆过滤器的长度
    public int len;
    //随机种子
    public int seed;

    public SimpleHash(int len, int seed) {
        this.len = len;
        this.seed = seed;
    }

    public int hash(Object key) {
        int h;
        return (key == null) ? 0 : (seed * len) * (h = key.hashCode()) ^ (h >>> 16);
    }
}

public class BloomFilter {
    public static final int DEFAULT_LEN = 1 << 20;

    private int[] seeds = {1, 3, 5, 7, 9};
    private BitSet bitSet;
    private SimpleHash[] simpleHashes;
    private int useSize;

    public BloomFilter() {
        this.bitSet = new BitSet(DEFAULT_LEN);
        this.simpleHashes = new SimpleHash[seeds.length];
        for (int i = 0; i < seeds.length; i++) {
            simpleHashes[i] = new SimpleHash(DEFAULT_LEN, seeds[i]);
        }
        this.useSize = 0;
    }

    //设置 - set
    public void set(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("数据越界");
        }
        for (int i = 0; i < simpleHashes.length; i++) {
            bitSet.set(simpleHashes[i].hash(val));
        }
        this.useSize++;
    }

    //检查是否包含某个元素
    public boolean contains(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("数据越界");
        }
        for (int i = 0; i < simpleHashes.length; i++) {
            if(!bitSet.get(simpleHashes[i].hash(val))){
                return false;
            }
        }
        return true;
    }
}
