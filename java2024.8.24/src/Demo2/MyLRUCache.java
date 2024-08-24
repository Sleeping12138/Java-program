package Demo2;

import java.util.HashMap;
import java.util.Map;

//自我实现LRUCache算法 - 自我实现LinkHashMap
public class MyLRUCache {
    public static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node() {

        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public int initial;
    public int usedSize;
    public Node head;
    public Node last;
    public Map<Integer, Node> map;

    public MyLRUCache(int initial) {
        this.initial = initial;
        this.head = new Node();
        this.last = new Node();
        head.next = last;
        last.prev = head;
        this.map = new HashMap<>();
    }

    //插入元素
    public void put(int key, int val) {
        Node node = map.get(key);
        if (node == null) {
            Node newNode = new Node(key, val);
            map.put(key, newNode);
            usedSize++;
            addLast(newNode);
            if (usedSize > initial) {
                Node ret = removeHead();
                map.remove(ret.key);
                usedSize--;
            }
        } else {
            node.val = val;
            adjuctLast(node);
        }
    }

    //获取元素
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        adjuctLast(node);
        return node.val;
    }

    private void adjuctLast(Node node) {
        removeNode(node);
        addLast(node);
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private Node removeHead() {
        Node ret = head.next;
        head.next = ret.next;
        ret.next.prev = head;
        return ret;
    }

    private void addLast(Node newNode) {
        last.prev.next = newNode;
        newNode.prev = last.prev;
        newNode.next = last;
        last.prev = newNode;

    }

    //打印其中的所有数据
    public void print() {
        Node cur = head.next;
        while (cur != last) {
            System.out.print(cur.key + "--" + cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
