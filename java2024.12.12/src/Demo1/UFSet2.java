package Demo1;

import java.util.*;

// 并查集的哈希表的实现方式
public class UFSet2 {
    private Map<Integer, Integer> map;
    private Map<Integer, Integer> size;

    public UFSet2() {
        map = new HashMap<>();
        size = new HashMap<>();
    }

    // 查找根节点，带路径压缩
    public int find(int val) {
        if (!map.containsKey(val)) map.put(val, val);
        if (!map.get(val).equals(val)) {
            map.put(val, find(map.get(val)));
        }
        return map.get(val);
    }

    // 合并两个集合，按秩优化
    public void merge(int val1, int val2) {
        int root1 = find(val1);
        int root2 = find(val2);
        if (root1 != root2) {
            int size1 = size.getOrDefault(root1, 1);
            int size2 = size.getOrDefault(root2, 1);

            if (size1 >= size2) {
                map.put(root2, root1);
                size.put(root1, size1 + size2);
            } else {
                map.put(root1, root2);
                size.put(root2, size1 + size2);
            }
        }
    }

    // 检查是否属于同一个集合
    public boolean isSame(int val1, int val2) {
        return find(val1) == find(val2);
    }

    // 获取集合的数量
    public int sumSet() {
        Set<Integer> set = new HashSet<>();
        for (int key : map.keySet()) {
            set.add(find(key));
        }
        return set.size();
    }
}

