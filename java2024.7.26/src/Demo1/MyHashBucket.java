package Demo1;

public class MyHashBucket {
    public static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodeArray = new Node[10];
    public int useSize;
    public static final double LOAD_FACTOR = 0.75;

    public void put(int key, int value) {
        int index = key % nodeArray.length;
        Node cur = nodeArray[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        Node node = new Node(key, value);
        node.next = nodeArray[index];
        nodeArray[index] = node;
        useSize++;

        //负载因子扩容问题
        if (calLoadFactor() > LOAD_FACTOR) {
            resize();
        }
    }

    private void resize() {
        Node[] newNodeArray = new Node[nodeArray.length * 2];
        for (int i = 0; i < nodeArray.length; i++) {
            Node cur = nodeArray[i];
            while (cur != null) {
                int newIndex = cur.key % newNodeArray.length;
                Node curNext = cur.next;
                cur.next = newNodeArray[newIndex];
                newNodeArray[newIndex] = cur;
                cur = curNext;
            }
        }
        nodeArray = newNodeArray;
    }

    private double calLoadFactor() {
        return useSize * 1.0 / nodeArray.length;
    }

    public int get(int key) {
        int index = key % nodeArray.length;
        Node cur = nodeArray[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }
}
