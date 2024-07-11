package Demo3;

//链式栈
public class MyListStack {
    //结点是个完整的个体 + 只想给外部类使用
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

    //入栈
    public void push(int number) {
        ListNode newNode = new ListNode(number);
        if (head == null) {
            head = last = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    //出栈
    public void pop() {
        if (head == null) {
            throw new StackIsEmptyException("栈中没有元素！！！ ");
        }
        if (head == last) {
            head = last = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    //返回栈顶元素
    public int peek() {
        if (head == null) {
            throw new StackIsEmptyException("栈中没有元素！！！ ");
        }
        return head.val;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return head == null;
    }

    //打印栈中所有元素
    public void printStack() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //返回栈中元素的个数
    public int size() {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

}
