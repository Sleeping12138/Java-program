package Demo2;

public class MyLinkedList {
    public static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode last;

    //头插
    public void addFirst(int number) {
        ListNode newNode = new ListNode(number);
        if (head == null) {
            head = last = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    //尾插
    public void addLast(int number) {
        ListNode newNode = new ListNode(number);
        if (head == null) {
            head = last = newNode;
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
    }

    //在指定位置插入元素
    public void addIndex(int pos, int number) {
        ListNode newNode = new ListNode(number);
        int len = this.size();
        if (pos < 0 || pos > len) {
            System.out.println("索引错误！！！");
        }
        if (pos == 0) {
            this.addFirst(number);
            return;
        }
        if (pos == len) {
            this.addLast(number);
            return;
        }
        ListNode cur = head;
        while (pos != 0) {
            cur = cur.next;
            pos--;
        }
        newNode.next = cur;
        cur.prev.next = newNode;
        newNode.prev = cur.prev;
        cur.prev = newNode;
    }

    //删除指定元素
    public void remove(int key) {
        if (head == null) {
            return;
        }
        ListNode keyNode = findKeyNode(key);
        if (keyNode == null) {
            return;
        }
        if (head == last) {
            head = last = null;
            return;
        }
        if (keyNode == head) {
            head = head.next;
            head.prev = null;
            return;
        }
        if (keyNode == last) {
            last = last.prev;
            last.next = null;
            return;
        }
        keyNode.prev.next = keyNode.next;
        keyNode.next.prev = keyNode.prev;
    }

    //删除指定的所有元素
    public void removeAll(int key) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                this.remove(key);
            }
            cur = cur.next;
        }
    }

    private ListNode findKeyNode(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //清空所有元素
    public void clear(){
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.prev = cur.next = null;
            cur = curNext;
        }
        head = last = null;
    }

    //遍历
    public void printList() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //返回双向链表的个数
    public int size() {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    //是否包含某个元素
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
