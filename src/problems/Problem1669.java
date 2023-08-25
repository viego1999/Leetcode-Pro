package problems;

import util.ListNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1669
 * @since 2023/1/30 10:09
 */
public class Problem1669 {

    public static void main(String[] args) {

    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1, list1), prev = dummy;
        for (int i = 0; i < a; i++) prev = prev.next;
        ListNode last = prev, p = list2;
        for (int i = a; i <= b; i++) last = last.next;
        while (p.next != null) p = p.next;
        prev.next = list2;
        p.next = last.next;
        return dummy.next;
    }
}
