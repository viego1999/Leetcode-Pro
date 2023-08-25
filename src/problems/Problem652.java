package problems;

import util.TreeNode;

import java.util.*;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树 root，返回所有重复的子树。
 *
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * 示例 3：
 *
 *
 *
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 *
 *
 * 提示：
 *
 * 树中的结点数在[1,10^4]范围内。
 * -200 <= Node.val <= 200
 *
 * link: https://leetcode.cn/problems/find-duplicate-subtrees/
 */
public class Problem652 {
    public static void main(String[] args) {

    }

    Map<String, TreeNode> map = new HashMap<>();
    Set<TreeNode> idxs = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(idxs);
    }

    public String dfs(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(" ").append(dfs(root.left)).append("l").append(dfs(root.right)).append("r");
        String str = sb.toString();
        if (map.get(str) != null) idxs.add(map.get(str));
        else map.put(str, root);
        return str;
    }

    /*
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    public String dfs(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(" ").append(dfs(root.left)).append("l").append(dfs(root.right)).append("r");
        String str = sb.toString();
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) ans.add(root);
        return str;
    }
    */
}
