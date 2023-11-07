package problems;

import util.ListNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem148_
 * @since 2023/9/5 14:10
 */
public class Problem148_ {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        return quickSort(head)[0];
    }

    public ListNode[] quickSort(ListNode head) {
        if (head == null || head.next == null) return new ListNode[]{head, head};
        ListNode small = new ListNode(-1), large = new ListNode(-1), p = head.next, sp = small, lp = large;
        int pivot = head.val;
        while (p != null) {
            ListNode next = p.next;
            p.next = null;
            if (p.val > pivot) {
                lp.next = p;
                lp = lp.next;
            } else {
                sp.next = p;
                sp = sp.next;
            }
            p = next;
        }
        head.next = sp.next = lp.next = null;
        ListNode[] lefts = quickSort(small.next), rights = quickSort(large.next);
        if (lefts[1] != null) lefts[1].next = head;
        head.next = rights[0];
        ListNode newHead = lefts[0] == null ? head : lefts[0];
        ListNode newTail = rights[1] == null ? head : rights[1];
        return new ListNode[]{newHead, newTail};
    }
}
