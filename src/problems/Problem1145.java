package problems;

import util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1145
 * @since 2023/2/3 10:53
 */
public class Problem1145 {
    public static void main(String[] args) {

    }

    TreeNode xnode;

    // 规律
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        findXNode(root, x);
        int leftCnt = getCnt(xnode.left), rightCnt = getCnt(xnode.right);
        return leftCnt > n - leftCnt || rightCnt > n - rightCnt || n - leftCnt - rightCnt - 1 > n / 2;
    }

    public void findXNode(TreeNode root, int x) {
        if (root == null) return;
        if (root.val == x) xnode = root;
        findXNode(root.left, x);
        findXNode(root.right, x);
    }

    public int getCnt(TreeNode node) {
        if (node == null) return 0;
        return 1 + getCnt(node.left) + getCnt(node.right);
    }

    // 模拟
    static class Solution {
        TreeNode xnode;
        Map<TreeNode, TreeNode> prevs = new HashMap<>();
        Set<TreeNode> set1, set2;
        int stop = 0;

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            findXNode(null, root, x);
            return helper(n, prevs.get(xnode)) || helper(n, xnode.left) || helper(n, xnode.right);
        }

        public void findXNode(TreeNode prev, TreeNode root, int x) {
            if (root == null) return;
            prevs.put(root, prev);
            if (root.val == x) xnode = root;
            findXNode(root, root.left, x);
            findXNode(root, root.right, x);
        }

        public boolean helper(int n, TreeNode ynode) {
            if (ynode == null || ynode == xnode) return false;
            set1 = new HashSet<>();
            set2 = new HashSet<>();
            set1.add(xnode);
            set2.add(ynode);
            dfs(0);
            return stop == 0 ? set1.size() < n - set1.size() : set2.size() > n - set2.size();
        }

        public void dfs(int turn) {
            boolean f = false;
            for (TreeNode node : turn == 0 ? set1 : set2) {
                TreeNode next, prev = prevs.get(node), left = node.left, right = node.right;
                if (left != null && !set1.contains(left) && !set2.contains(left)) next = left;
                else if (right != null && !set1.contains(right) && !set2.contains(right)) next = right;
                else if (prev != null && !set1.contains(prev) && !set2.contains(prev)) next = prev;
                else continue;
                f = true;
                if (turn == 0) set1.add(next);
                else set2.add(next);
                dfs(turn ^ 1);
                break;
            }
            if (!f) stop = turn;
        }
    }
}
