package offer2s;

import util.ListNode;

import java.util.PriorityQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII078
 * @since 2023/5/17 15:49
 */
public class OfferII078 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode list : lists) {
            while (list != null) {
                ListNode next = list.next;
                list.next = null;
                pq.offer(list);
                list = next;
            }
        }
        ListNode dummy = new ListNode(-1), p = dummy;
        while (!pq.isEmpty()) {
            p.next = pq.poll();
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode mergeKListsBf(ListNode[] lists) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (true) {
            int idx = -1, val = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < val) {
                    idx = i;
                    val = lists[i].val;
                }
            }
            if (idx == -1) break;
            else {
                ListNode next = lists[idx].next;
                p.next = lists[idx];
                lists[idx].next = null;
                lists[idx] = next;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
