package problems;

import util.ListNode;

import java.util.BitSet;

public class Problem817 {
    public static void main(String[] args) {

    }

    public int numComponents(ListNode head, int[] nums) {
        BitSet bs = new BitSet();
        int ans = 0;
        for (int num : nums) bs.set(num);
        ListNode p = head;
        while (p != null) {
            while (p != null && !bs.get(p.val)) p = p.next;
            if (p != null) {
                ans++;
                while (p != null && bs.get(p.val)) p = p.next;
            }
        }
        return ans;
    }
}
