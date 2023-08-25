package offer2s;

import util.ListNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII021
 * @since 2023/4/6 20:12
 */
public class OfferII021 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head), slow = dummy, fast = dummy;
        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
