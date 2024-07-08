package Demo2;

//无头单向不循环链表
public class MySingleList {
    //完整的结构 + 只希望给外部类使用
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //设置头节点
    public ListNode head;

    //头插
    public void addFirst(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head;
        this.head = newNode;
    }

    //尾插
    public void addLast(int val) {
        ListNode newNode = new ListNode(val);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    //在指定位置插入
    public void indexAdd(int index, int val) {
        int listSize = this.size();
        if (index < 0 || index > listSize) {
            System.out.println("索引异常！！！");
            return;
        }
        if (index == 0) {
            this.addFirst(val);
            return;
        }
        ListNode cur = this.head;
        while (index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
    }

    //删除指定元素
    private ListNode findKeyNode(int key) {
        if (this.head == null) {
            return null;
        }
        ListNode cur = this.head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        return null;
    }

    public void remove(int val) {
        if (this.head == null) {
            return;
        }
        if (this.head.val == val) {
            this.head = head.next;
            return;
        }
        ListNode target = findKeyNode(val);
        if (target != null) {
            target.next = target.next.next;
        }
    }

    //删除指定的所有元素
    public void removeAll(int key) {
        if (this.head == null) {
            return;
        }
        ListNode prev = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.val == key) {
            this.head = this.head.next;
        }
    }

    //遍历打印
    public void printList() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //返回链表中的元素个数
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
