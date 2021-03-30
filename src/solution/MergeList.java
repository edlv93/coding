package solution;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 */

public class MergeList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur      = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = generate(new int[]{1, 4, 5});
        lists[1] = generate(new int[]{1, 3, 4});
        lists[2] = generate(new int[]{2, 6});
        new MergeList().mergeKLists(lists);
    }

    public static ListNode generate(int[] nums) {
        ListNode list = new ListNode();
        ListNode head = list;
        for (int i = 0; i < nums.length; i++) {
            list.next = new ListNode(nums[i]);
            list      = list.next;
        }
        return head.next;
    }
}
