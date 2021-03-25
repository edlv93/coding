package solution;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = -1;
        List<Integer> nodes = new ArrayList<>();
        while (l1 != null || l2 != null || n != -1) {
            int tmp = n == -1 ? 0 : n;
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            if (tmp > 9) {
                n = tmp / 10;
                tmp -= 10;
            } else {
                n = -1;
            }
            nodes.add(tmp);
        }
        if (nodes.size() == 0) {
            return null;
        }
        ListNode result = new ListNode(nodes.get(nodes.size() - 1));
        for (int i = nodes.size() - 2; i >= 0; i--) {
            ListNode tmp = new ListNode(nodes.get(i));
            tmp.next = result;
            result   = tmp;
        }
        return result;
    }

    public ListNode generateListNode(int[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        ListNode result = new ListNode(nodes[nodes.length - 1]);
        for (int i = nodes.length - 2; i >= 0; i--) {
            ListNode tmp = new ListNode(nodes[i]);
            tmp.next = result;
            result   = tmp;
        }
        return result;
    }

    public void toString(ListNode node) {
        StringBuilder result = new StringBuilder(node.val + "");
        while (node.next != null) {
            node = node.next;
            result.append(">").append(node.val);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] l1 = {2, 4, 3};
        int[] l2 = {5, 6, 4};
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node1 = addTwoNumbers.generateListNode(l1);
        addTwoNumbers.toString(node1);
        ListNode node2 = addTwoNumbers.generateListNode(l2);
        addTwoNumbers.toString(node2);
        addTwoNumbers.toString(addTwoNumbers.addTwoNumbers(node1, node2));
    }
}
