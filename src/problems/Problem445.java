package problems;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem445
 * @since 2023/7/3 19:19
 */
public class Problem445 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        ListNode l3 = new ListNode(-1);
        int i = list1.size() - 1, j = list2.size() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int val = (i >= 0 ? list1.get(i--) : 0) + (j >= 0 ? list2.get(j--) : 0) + carry;
            ListNode node = new ListNode(val % 10);
            node.next = l3.next;
            l3.next = node;
            carry = val / 10;
        }
        return l3.next;
    }
}
