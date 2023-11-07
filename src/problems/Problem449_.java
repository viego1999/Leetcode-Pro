package problems;

import util.TreeNode;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem449_
 * @since 2023/9/4 10:59
 */
public class Problem449_ {
    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * <pre>{@code
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     * }</pre>
     */
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<String> list = new ArrayList<>();
            dfs(root, list);
            return String.join(",", list);
        }

        public void dfs(TreeNode root, List<String> list) {
            if (root == null) list.add("null");
            else {
                list.add(String.valueOf(root.val));
                dfs(root.left, list);
                dfs(root.right, list);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strs = data.split(",");
            Deque<String> deque = new ArrayDeque<>();
            Collections.addAll(deque, strs);
            return build(deque);
        }

        public TreeNode build(Deque<String> deque) {
            if (deque.isEmpty()) return null;
            String str = deque.removeFirst();
            if ("null".equals(str)) return null;
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = build(deque);
            node.right = build(deque);
            return node;
        }
    }
}
