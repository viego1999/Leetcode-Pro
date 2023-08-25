package offer2s;

import util.ListNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII025
 * @since 2023/4/11 22:03
 */
public class OfferII025 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int sum, carry = 0;
        ListNode dummy = new ListNode(-1);
        while (l1 != null || l2 != null || carry > 0) {
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
