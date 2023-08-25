package offer2s;

import util.ListNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII077
 * @since 2023/5/17 14:57
 */
public class OfferII077 {
    public static void main(String[] args) {
        
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head), slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        head = sortList(head);
        right = sortList(right);
        return merge(head, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (left != null || right != null) {
            if (left != null && right != null) {
                if (left.val < right.val) {
                    p.next = left;
                    ListNode next = left.next;
                    left.next = null;
                    left = next;
                } else {
                    p.next = right;
                    ListNode next = right.next;
                    right.next = null;
                    right = next;
                }
            } else if (left != null) {
                p.next = left;
                ListNode next = left.next;
                left.next = null;
                left = next;
            } else {
                p.next = right;
                ListNode next = right.next;
                right.next = null;
                right = next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode sortListQuickSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode povit = head, lows = new ListNode(), ups = new ListNode(), p = lows, q = ups;
        head = head.next;
        while (head != null) {
            ListNode now = head;
            head = head.next;
            now.next = null;
            if (now.val > povit.val) {
                q.next = now;
                q = q.next;
            } else {
                p.next = now;
                p = p.next;
            }
        }
        lows.next = sortListQuickSort(lows.next);
        ups.next = sortListQuickSort(ups.next);
        p = lows;
        while (p.next != null) p = p.next;
        p.next = povit;
        povit.next = ups.next;
        return lows.next;
    }
}
