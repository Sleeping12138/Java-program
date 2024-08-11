package Demo1;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用Java内置的LinkHashMap来实现LRU
 */
public class LRUCache extends LinkedHashMap<String, Integer> {
    private int initial;

    public LRUCache(int initial) {
        super(initial, 0.75f, true);
        this.initial = initial;
    }

    @Override
    public Integer put(String key, Integer value) {
        return super.put(key, value);
    }

    @Override
    public Integer get(Object key) {
        return super.get(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > initial;
    }
}
