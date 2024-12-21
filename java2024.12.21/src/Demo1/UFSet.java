package Demo1;

import java.util.Arrays;
import java.util.HashMap;

// 使用哈希表进行索引绑定
public class UFSet {
    public HashMap<String, Integer> map = new HashMap<>();
    public int[] node;

    public UFSet(int n) {
        node = new int[n];
        Arrays.fill(node, -1);
    }

    public int find(String str) {
        if (!map.containsKey(str)) {
            int size = map.size();
            map.put(str, size);
        }

        int index = map.get(str);
        return findRoot(index);
    }

    public int findRoot(int index) {
        if (node[index] < 0) return index;
        node[index] = findRoot(node[index]);
        return node[index];
    }

    public void merge(String str1, String str2) {
        int root1 = find(str1);
        int root2 = find(str2);

        if (root1 != root2) {
            if (node[root1] < node[root2]) {
                node[root1] += node[root2];
                node[root2] = root1;
            } else {
                node[root2] += node[root1];
                node[root1] = root2;
            }
        }
    }

    public boolean isSame(String str1, String str2) {
        return find(str1) == find(str2);
    }

    public int sumNum() {
        int sum = 0;
        for (int number : node) {
            if (number < 0) sum++;
        }
        return sum;
    }
}
