package com.test.spring2025_5_3.Demo;

import java.util.Arrays;

public class UFSet {
    public int[] array;

    public UFSet(int n) {
        array = new int[n];
        Arrays.fill(array, -1);
    }

    // 找根
    public int find(int x) {
        if (array[x] < 0) return x;
        array[x] = find(array[x]);
        return array[x];
    }

    // 合并两个集合
    public void merge(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (array[rootX] <= array[rootY]) {
            array[rootX] += array[rootY];
            array[rootY] = rootX;
        } else {
            array[rootY] += array[rootX];
            array[rootX] = rootY;
        }
    }

    // 查找两个元素是否为同一个集合
    public boolean isSameTree(int x, int y) {
        return find(x) == find(y);
    }

    // 返回某个集合个数
    public int getNum(int x) {
        int root = find(x);
        return -array[root];
    }
}
