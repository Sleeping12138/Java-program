package unionFindSet;

import java.util.Arrays;

//并查集的自我实现
public class UnionFindSet {
    private int[] elements;

    //并查集的初始化
    public UnionFindSet(int initial) {
        elements = new int[initial];
        Arrays.fill(elements, -1);
    }

    //查找两个元素是否属于一个集合
    public boolean isSameSet(int val1, int val2) {
        return findRoot(val1) == findRoot(val2);
    }

    public int findRoot(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("数据异常");
        }
        while (elements[val] >= 0) {
            val = elements[val];
        }
        return val;
    }

    //查找是否为同一个集合的路径压缩 - 将所有的节点直接连接根节点
    public int findRoot2(int val) {
        if (val < 0 || val > elements.length) {
            throw new ArrayIndexOutOfBoundsException("数据异常！！！");
        }
        if (elements[val] < 0) {
            return val;
        } else {
            elements[val] = findRoot2(elements[val]);
            return elements[val];
        }
    }

    //合并两个集合
    public void unionSet(int val1, int val2) {
        int root1 = findRoot(val1);
        int root2 = findRoot(val2);
        if (root1 != root2) {
            elements[root1] += elements[root2];
            elements[root2] = root1;
        }
    }

    //合并两个集合的路径压缩 - 将树矮的连接到树高的上边
    public void unionSet2(int val1, int val2) {
        int root1 = findRoot2(val1);
        int root2 = findRoot2(val2);
        if (root1 != root2) {
            if (elements[root1] < elements[root2]) {
                elements[root1] += elements[root2];
                elements[root2]=root1;
            }else{
                elements[root2] += elements[root1];
                elements[root1]=root2;
            }
        }
    }

    //获取集合个数
    public int getSetNumber() {
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < 0) {
                count++;
            }
        }
        return count;
    }
}
