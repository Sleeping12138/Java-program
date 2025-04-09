package com.Test.Demo1;


public class code2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        int sub = Math.abs(lenA - lenB);

        if (lenA > lenB) {
            while (sub-- != 0) headA = headA.next;
        }
        if (lenA < lenB) {
            while (sub-- != 0) headB = headB.next;
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }

    public int getLen(ListNode head) {
        int ret = 0;
        ListNode cur = head;
        while (cur != null) {
            ret++;
            cur = cur.next;
        }
        return ret;
    }
}
