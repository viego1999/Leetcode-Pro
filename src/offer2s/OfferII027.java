package offer2s;

import util.ListNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII027
 * @since 2023/4/12 14:11
 */
public class OfferII027 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow.next;
        slow.next = null;
        while (p != null) {
            ListNode next = p.next;
            p.next = slow.next;
            slow.next = p;
            p = next;
        }
        p = slow.next;
        while (head != null && p != null) {
            if (head.val != p.val) return false;
            head = head.next;
            p = p.next;
        }
        return true;
    }
}
