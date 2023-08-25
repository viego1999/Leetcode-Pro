package offer2s;

import util.ListNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII023
 * @since 2023/4/6 20:48
 */
public class OfferII023 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
