package Demo2;

public class Test {
    public static void main(String[] args) {
        MyLRUCache lru = new MyLRUCache(4);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.print();
        lru.put(5, 5);
        lru.print();
    }
}
