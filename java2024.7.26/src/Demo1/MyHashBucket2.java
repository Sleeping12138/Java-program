package Demo1;

public class MyHashBucket2<K, V> {
    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public Node<K, V>[] nodeArray = (Node<K, V>[]) new Node[10];
    public int useSize;
    public static final double LOAD_FACTOR = 0.75;

    public void put(K key, V value) {
        int hashcode = key.hashCode();
        int index = hashcode % nodeArray.length;
        Node cur = nodeArray[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = nodeArray[index];
        nodeArray[index] = newNode;
        useSize++;
        if (calLoadFactor() > LOAD_FACTOR) {
            resize();
        }
    }

    private void resize() {
        Node<K, V>[] newNodeArray = (Node<K, V>[]) new Node[nodeArray.length * 2];
        for (int i = 0; i < nodeArray.length; i++) {
            Node<K, V> cur = nodeArray[i];
            while (cur != null) {
                int hashCode = cur.key.hashCode();
                int index = hashCode % newNodeArray.length;
                Node<K, V> curNext = cur.next;
                cur.next = newNodeArray[index];
                newNodeArray[index] = cur;
                cur = curNext;
            }
        }
        nodeArray = newNodeArray;
    }

    private double calLoadFactor() {
        return useSize * 1.0 / nodeArray.length;
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        int index = hashCode%nodeArray.length;
        Node<K, V> cur = nodeArray[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

}
