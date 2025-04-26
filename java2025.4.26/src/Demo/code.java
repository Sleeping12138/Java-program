package Demo;

import java.util.PriorityQueue;

public class code {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
            if (fast == null || fast.next == null)
                return null;

            // 最重要的就是推到出相遇节点到入环节点的距离 = head到入环节点的距离
            ListNode cur = head;
            while (cur != slow) {
                cur = cur.next;
                slow = slow.next;
            }
            return cur;

        }
    }
}
