package Demo;

public class code2 {
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

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode newHead = new ListNode(0);
            ListNode cur = newHead;
            ListNode cur1 = list1, cur2 = list2;
            while (cur1 != null && cur2 != null) {
                if (cur1.val < cur2.val) {
                    cur.next = cur1;
                    cur = cur.next;
                    cur1 = cur1.next;
                } else {
                    cur.next = cur2;
                    cur = cur.next;
                    cur2 = cur2.next;
                }
            }

            if (cur1 != null) cur.next = cur1;
            else cur.next = cur2;
            return newHead.next;
        }
    }
}
