package bytedance;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            head     = head.next;
            cur.next = null;
            nodes.add(cur);
            cur = head;
        }
        int n = nodes.size();
        int l = 0, r = n - 1;
        while (l < r) {
            ListNode first = nodes.get(l), second = nodes.get(r);
            if (r != n - 1) {
                nodes.get(r + 1).next = nodes.get(l);
            }
            first.next = second;
            l++;
            r--;
        }
        if (n > 2 && n % 2 == 1) {
            nodes.get(r + 1).next = nodes.get(l);
        }
    }
}
