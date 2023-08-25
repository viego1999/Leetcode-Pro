package problems;

import java.util.*;

public class Problem46_ {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, nums, new LinkedList<>(), new boolean[nums.length], 0);

        return lists;
    }

    public static void backtrack(List<List<Integer>> lists, int[] nums, Deque<Integer> list, boolean[] used, int t) {
        if (t == nums.length) lists.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    list.add(nums[i]);
                    used[i] = true;
                    backtrack(lists, nums, list, used, t + 1);
                    list.removeLast();
                    used[i] = false;
                }
            }
        }
    }
}
