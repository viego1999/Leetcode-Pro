package offer2s;

import util.ListNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII022
 * @since 2023/4/6 20:36
 */
public class OfferII022 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean flag = false; // 判断是否有环
        while (fast != null && fast.next != null && !flag) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) flag = true; // 有环

        }
        if (!flag) return null;
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
