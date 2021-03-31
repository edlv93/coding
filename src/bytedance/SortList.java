package bytedance;

import common.ListNode;

/**
 * 148. 排序链表
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode pre = dummy;
            cur = dummy.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur      = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next     = cur.next;
                    cur.next = null;
                }
                pre.next = mergeTwoLists(head1, head2);
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1       = l1.next;
            } else {
                cur.next = l2;
                l2       = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
