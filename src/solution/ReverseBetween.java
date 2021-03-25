package solution;

import common.ListNode;

/**
 * 反转链表 II
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //增加虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        //找到left的前驱结点
        ListNode prev = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        //找到right结点
        ListNode rightNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = prev.next; //left结点
        ListNode tail = rightNode.next;//right结点的后继结点

        //把left到right之间的链表和主链表断开
        prev.next      = null;
        rightNode.next = null;

        //反转left-right
        ListNode pre = null;
        ListNode cur = leftNode;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre      = cur;
            cur      = next;
        }

        //重新连接链表
        prev.next     = rightNode;
        leftNode.next = tail;

        return dummyHead.next;
    }
}
