package problems;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Problem6247 {
    public static void main(String[] args) {

    }

    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        int[] arr = new int[100005];
        int n = 0;
        while (head != null) {
            arr[n++] = head.val;
            head = head.next;
        }
        for (int i = n - 1, last = 0; i >= 0; i--) {
            if (arr[i] >= last) {
                ListNode node = new ListNode(arr[i]);
                node.next = dummy.next;
                dummy.next = node;
                last = arr[i];
            }
        }
        return dummy.next;
    }

    public ListNode removeNodes_(ListNode head) {
        ListNode dummy = new ListNode(0);
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = list.size() - 1, last = 0; i >= 0; i--) {
            int v = list.get(i);
            if (v >= last) {
                ListNode node = new ListNode(v);
                node.next = dummy.next;
                dummy.next = node;
                last = v;
            }
        }
        return dummy.next;
    }
}
