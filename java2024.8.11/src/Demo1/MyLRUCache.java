package Demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * 自行创建一个哈希表 + 双向链表来实现LRU
 */
public class MyLRUCache {
    public static class DLinkNode {
        public int key;
        public int val;
        public DLinkNode prev;
        public DLinkNode next;

        public DLinkNode() {

        }

        public DLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public int initial;
    public int useSize;
    public DLinkNode head;
    public DLinkNode last;
    public Map<Integer, DLinkNode> map;

    public MyLRUCache(int initial) {
        this.initial = initial;
        this.head = new DLinkNode();
        this.last = new DLinkNode();
        head.next = last;
        last.prev = head;
        this.map = new HashMap<>();
    }

    //put方法
    public void put(int key, int val) {
        DLinkNode dLinkNode = map.get(key);
        if (dLinkNode == null) {
            DLinkNode newNode = new DLinkNode(key, val);
            map.put(key, newNode);
            addLastNode(newNode);
            useSize++;
            if (useSize > initial) {
                DLinkNode removeNode = removeHead();
                map.remove(removeNode.key);
                useSize--;
            }
        }else{
            dLinkNode.val = val;
            adjustLast(dLinkNode);
        }
    }

    //get方法
    public int get(int key){
        DLinkNode dLinkNode = map.get(key);
        if (dLinkNode == null) {
            return -1;
        }
        removeNode(dLinkNode);
        return dLinkNode.val;
    }

    private void adjustLast(DLinkNode dLinkNode) {
        removeNode(dLinkNode);
        addLastNode(dLinkNode);
    }

    private void removeNode(DLinkNode dLinkNode) {
        dLinkNode.prev.next = dLinkNode.next;
        dLinkNode.next.prev = dLinkNode.prev;
    }

    private DLinkNode removeHead() {
        DLinkNode delete = head.next;
        head.next = delete.next;
        delete.next.prev = head;
        return delete;
    }

    private void addLastNode(DLinkNode newNode) {
        last.prev.next = newNode;
        newNode.prev = last.prev;
        newNode.next = last;
        last.prev = newNode;
    }

    public void print(){
        DLinkNode cur = head.next;
        while (cur != last) {
            System.out.println("{ "+cur.key + " " +cur.val + " }");
            cur = cur.next;
        }
    }

}
