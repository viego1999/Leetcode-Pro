package problems;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem437 {

    public int pathSum_(TreeNode root, long targetSum) {
        if (root == null) return 0;
        return rootSum(root, targetSum) + pathSum_(root.left, targetSum) + pathSum_(root.right, targetSum);
    }

    public int rootSum(TreeNode root, long targetSum) {
        if (root == null) return 0;
        int cnt = root.val == targetSum ? 1 : 0;
        int lefts = rootSum(root.left, targetSum - root.val);
        int rights = rootSum(root.right, targetSum - root.val);
        return cnt + lefts + rights;
    }

    Map<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, long targetSum) {
        map.put(0L, 1);
        return dfs(root, 0, targetSum);
    }

    public int dfs(TreeNode root, long cur, long targetSum) {
        if (root == null) return 0;
        cur += root.val;
        int ans = map.getOrDefault(cur - targetSum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        ans += dfs(root.left, cur, targetSum) + dfs(root.right, cur, targetSum);
        map.put(cur, map.getOrDefault(cur, 0) - 1);
        return ans;
    }
}
