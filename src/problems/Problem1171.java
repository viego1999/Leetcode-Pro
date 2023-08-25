package problems;

import util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1171
 * @since 2023/6/11 22:17
 */
public class Problem1171 {
    public static void main(String[] args) {

    }

    public ListNode removeZeroSumSublists_(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0, head), p = dummy;
        int sum = 0;
        while (p != null) {
            sum += p.val;
            ListNode node = map.get(sum);
            if (node != null) {
                ListNode q = node.next;
                int temp = sum;
                while (q != null && q != p.next) {
                    map.remove((temp += q.val));
                    q = q.next;
                }
                node.next = p.next;
                p = node;
                sum -= p.val;
            } else {
                map.put(sum, p);
                p = p.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return head;
        int sum = 0;
        for (ListNode p = head; p != null; p = p.next) {
            if ((sum += p.val) == 0) return removeZeroSumSublists(p.next);
        }
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}
