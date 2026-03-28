package problems;

import util.ListNode;

public class Problem234 {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next, prev = new ListNode(-1);
        slow.next = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = prev.next;
            prev.next = second;
            second = next;
        }
        second = prev.next;
        while (head != null && second != null) {
            if (head.val != second.val) return false;
            head = head.next;
            second = second.next;
        }
        return true;
    }
}
