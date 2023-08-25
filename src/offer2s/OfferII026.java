package offer2s;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII026
 * @since 2023/4/12 13:24
 */
public class OfferII026 {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1), p = head;
        List<ListNode> list = new ArrayList<>();
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        p = dummy;
        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            ListNode node = list.get(i);
            node.next = null;
            p.next = node;
            p = p.next;
            if (i != j) {
                node = list.get(j);
                node.next = null;
                p.next = node;
                p = p.next;
            }
        }
    }
}
