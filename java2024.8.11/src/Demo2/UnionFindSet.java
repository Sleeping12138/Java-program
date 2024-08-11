package Demo2;

import java.util.Arrays;

/**
 * 并查集常用情况：
 * （1）查看两个元素是否属于同一个集合
 * （2）合并两个集合
 */

public class UnionFindSet {
    //并查集的底层为一个数组
    private int[] element;

    public UnionFindSet(int initial) {
        element = new int[initial];
        Arrays.fill(element, -1);
    }

    //查找两个元素是否在同一个集合内
    public boolean isSameSet(int val1, int val2) {
        return findRoot(val1) == findRoot(val2);
    }

    private int findRoot(int val) {
        if (val < 0) {
            throw new ArrayIndexOutOfBoundsException("索引越界！！！");
        }
        while (element[val] >= 0) {
            val = element[val];
        }
        return val;
    }

    //路径压缩 - 查找根节点
    public int findRoot2(int val){
        if (val < 0 || val > element.length) {
            throw new ArrayIndexOutOfBoundsException("索引越界!!!");
        }
        if (element[val] < 0) {
            return val;
        }else {
            element[val] = findRoot2(element[val]);
            return element[val];
        }
    }

    //合并两个集合
    public void unionSet(int val1, int val2) {
        int index1 = findRoot(val1);
        int index2 = findRoot(val2);
        if (!(index1 == index2)) {
            element[index1] = element[index1] + element[index2];
            element[index2] = index1;
        }
    }

    //路径压缩 - 合并两个集合
    public void unionSet2(int val1, int val2) {
        int index1 = findRoot(val1);
        int index2 = findRoot(val2);
        if (index1 != index2) {
            if (element[index1] < element[index2]) {
                element[index1] += element[index2];
                element[index2] = index1;
            }else {
                element[index2] += element[index1];
                element[index1] = index2;
            }
        }
    }

    //返回集合个数
    public int SetNumber() {
        int count = 0;
        for (int i = 0; i < element.length; i++) {
            if (element[i] < 0) {
                count++;
            }
        }
        return count;
    }
}
