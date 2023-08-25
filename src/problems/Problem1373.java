package problems;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1373
 * @since 2023/5/20 10:20
 */
public class Problem1373 {
    public static void main(String[] args) {
        System.out.println(0x3f3f3f3f);
        System.out.println(-0x3f3f3f3f);
    }

    int ans = 0, base = 0x3f3f3f3f;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, base, -base};
        int[] ret = new int[]{0, -base, base};
        int[] lefts = dfs(node.left), rights = dfs(node.right);
        if (node.val > lefts[2] && node.val < rights[1]) {
            ret[0] = node.val + lefts[0] + rights[0];
            ret[1] = Math.min(node.val, Math.min(lefts[1], rights[1]));
            ret[2] = Math.max(node.val, Math.max(lefts[2], rights[2]));
            ans = Math.max(ans, ret[0]);
        }
        return ret;
    }

    private static class Solution {
        Map<TreeNode, Boolean> flags = new HashMap<>();
        Map<TreeNode, Integer> sums = new HashMap<>();
        Map<TreeNode, Integer> mins = new HashMap<>();
        Map<TreeNode, Integer> maxs = new HashMap<>();
        int ans = 0;

        public int maxSumBST(TreeNode root) {
            dfs(root);
            return ans;
        }

        public int dfs(TreeNode node) {
            if (node == null) return 0;
            int sum = node.val + dfs(node.left) + dfs(node.right);
            int min = Math.min(node.val, Math.min(mins.getOrDefault(node.left, 0x3f3f3f3f), mins.getOrDefault(node.right, 0x3f3f3f3f)));
            int max = Math.max(node.val, Math.max(maxs.getOrDefault(node.left, Integer.MIN_VALUE), maxs.getOrDefault(node.right, Integer.MIN_VALUE)));
            sums.put(node, sum);
            mins.put(node, min);
            maxs.put(node, max);
            boolean flag = false, l = flags.getOrDefault(node.left, false), r = flags.getOrDefault(node.right, false);
            if (node.left == null && node.right == null) {
                flag = true;
            } else if (node.left == null) {
                if (node.val < mins.get(node.right) && r) flag = true;
            } else if (node.right == null) {
                if (node.val > maxs.get(node.left) && l) flag = true;
            } else {
                if (node.val > maxs.get(node.left) && node.val < mins.get(node.right) && l && r) flag = true;
            }
            if (flag) {
                flags.put(node, flag);
                ans = Math.max(ans, sum);
            }
            return sum;
        }
    }
}
