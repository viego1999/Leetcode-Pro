package problems;

import util.ListNode;

public class Problem25_ {
    public static void main(String[] args) {
        Problem25_ p = new Problem25_();
        System.out.println(p.reverseKGroup_(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(p.reverseKGroup_(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3));
    }

    public ListNode reverseKGroup_(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head), p = dummy;
        // 每次循环遍历k个，记录每一组的前驱节点
        while (true) {
            ListNode prev = p;
            for (int i = 0; i < k; i++) {
                p = p.next;
                if (p == null) return dummy.next; // 当不足k个表明已经到达最后一组
            }
            ListNode succ = p.next, curr = prev.next, tail = curr; // 此处的tail就是这组链表的开头节点
            // 使用前插法将这k组链表反转
            while (curr != succ) {
                ListNode next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
                curr = next;
            }
            tail.next = succ; // 令这组的tail节点指向后继节点
            p = tail; // 更新下一组的前驱节点
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head), p = dummy;
        for (int i = 0; i < k && p != null; i++) {
            p = p.next;
        }
        if (p == null) return head;
        ListNode curr = dummy.next;
        dummy.next = reverseKGroup(p.next, k);
        p.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}
