package Demo1;

import java.util.Arrays;

class UnionFindSet {
    private int[] element;

    public UnionFindSet(int initial) {
        element = new int[initial];
        Arrays.fill(element, -1);
    }

    // 普通版
    private int findRoot1(int val) {
        while (element[val] >= 0) {
            val = element[val];
        }
        return val;
    }

    // 路径压缩版的 find 方法
    private int findRoot(int val) {
        if (element[val] < 0) {
            return val; // 如果当前节点是根节点，直接返回
        }
        // 路径压缩：将当前节点直接指向根节点
        element[val] = findRoot(element[val]);
        return element[val];
    }


    // 合并两个集合，路径压缩版
    public void unionSet(int val1, int val2) {
        int root1 = findRoot(val1);
        int root2 = findRoot(val2);

        if (root1 != root2) {
            if (element[root1] < element[root2]) {
                element[root1] += element[root2]; // 更新根节点的大小信息
                element[root2] = root1; // 将 root2 的根指向 root1
            } else {
                element[root2] += element[root1];
                element[root1] = root2; // 将 root1 的根指向 root2
            }
        }
    }

    // 返回集合个数
    public int setNumber() {
        int count = 0;
        for (int i = 0; i < element.length; i++) {
            if (element[i] < 0) {
                count++;
            }
        }
        return count;
    }
}

public class demo3 {
}
