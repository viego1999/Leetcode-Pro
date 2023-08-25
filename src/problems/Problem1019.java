package problems;

import util.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1019
 * @since 2023/4/11 12:01
 */
public class Problem1019 {
    public static void main(String[] args) {

    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                ans[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return ans;
    }
}
