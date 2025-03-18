package Demo1;

public class demo1 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        ListNode cur = head;
        int num = 0;
        while (cur != null) {
            cur = cur.next;
            num++;
        }

        int ret = k % num;
        if (ret == 0)
            return head;
        ListNode prev = head;
        while (ret-- > 0)
            prev = prev.next;
        cur = head;
        while (prev.next != null) {
            prev = prev.next;
            cur = cur.next;
        }

        ListNode res = cur.next;
        prev.next = head;
        cur.next = null;
        return res;
    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode cur1 = head;
        int newK = k - 1;
        while (newK-- > 0)
            cur1 = cur1.next;
        newK = k - 1;

        ListNode prev = head;
        while (newK-- > 0)
            prev = prev.next;
        ListNode cur2 = head;
        while (prev.next != null) {
            prev = prev.next;
            cur2 = cur2.next;
        }

        int temp = cur1.val;
        cur1.val = cur2.val;
        cur2.val = temp;
        return head;
    }
}
