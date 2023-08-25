package problems;

import util.ListNode;

public class Problem92_ {
    public static void main(String[] args) {
        Problem92_ p = new Problem92_();
        System.out.println(p.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4));
        System.out.println(p.reverseBetween(new ListNode(5), 5, 5));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next, tail = curr; // curr需要反转的节点，tail反转后的尾部
        prev.next = null;
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        tail.next = curr; // 此时curr指向了不需要反转的第一个节点
        return dummy.next;
    }

    public ListNode reverseBetween_(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), p = dummy;
        while (p.next != null && p.next.val != left) p = p.next;
        ListNode middle = p.next, q = middle;
        p.next = null;
        while (q != null && q.val != right) q = q.next;
        ListNode last = q.next, prev = middle;
        q.next = null;
        middle = reverse(middle);
        prev.next = last;
        p.next = middle;
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
