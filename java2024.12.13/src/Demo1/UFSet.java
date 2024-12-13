package Demo1;

import java.util.HashMap;
import java.util.HashSet;

// 使用哈希表实现并查集
public class UFSet {
    public HashMap<String, String> map;

    // 记录当前节点所在集合中的节点总数
    public HashMap<String, Integer> size;

    public UFSet() {
        map = new HashMap<>();
        size = new HashMap<>();
    }

    public String find(String val) {
        if (!map.containsKey(val)) map.put(val, val);
        if (!map.get(val).equals(val)) {
            map.put(val, find(map.get(val)));
        }
        return map.get(val);
    }

    public void merge(String val1, String val2) {
        String r1 = find(val1);
        String r2 = find(val2);

        if (!r1.equals(r2)) {
            int size1 = size.getOrDefault(r1, 1);
            int size2 = size.getOrDefault(r2, 1);
            if (size1 > size2) {
                map.put(r2, r1);
                size.put(r1, size1 + size2);
            } else {
                map.put(r1, r2);
                size.put(r2, size1 + size2);
            }
        }
    }

    public boolean isSame(String val1, String val2) {
        return find(val1).equals(find(val2));
    }

    public int sumSet() {
        HashSet<String> set = new HashSet<>();
        for (String e : map.keySet()) {
            set.add(find(e));
        }
        return set.size();
    }
}
