package offer2s;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII050
 * @since 2023/5/2 15:54
 */
public class OfferII050 {
    public static void main(String[] args) {

    }

    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1);
        return dfs(root, targetSum, 0);
    }

    public int dfs(TreeNode node, int target, long cur) {
        if (node == null) return 0;
        cur += node.val;
        int ans = map.getOrDefault(cur - target, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        ans += dfs(node.left, target, cur) + dfs(node.right, target, cur);
        map.put(cur, map.getOrDefault(cur, 0) - 1);
        return ans;
    }

    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return dfs2(root, targetSum, 0) + pathSum2(root.left, targetSum) + pathSum2(root.right, targetSum);
    }

    public int dfs2(TreeNode node, int target, long cur) {
        if (node == null) return 0;
        cur = cur + node.val;
        int ans = cur == target ? 1 : 0;
        return ans + dfs2(node.left, target, cur) + dfs2(node.right, target, cur);
    }
}
