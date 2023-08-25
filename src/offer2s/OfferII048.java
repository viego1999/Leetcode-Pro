package offer2s;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII048
 * @since 2023/5/2 15:21
 */
public class OfferII048 {
    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(TreeNode.createBinaryTree(new int[]{})));
        System.out.println(ans);
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Deque<String> deque = new ArrayDeque<>();
            dfs(root, deque);
            return String.join(",", deque);
        }

        private void dfs(TreeNode node, Deque<String> deque) {
            if (node == null) deque.add("null");
            else {
                deque.add(String.valueOf(node.val));
                dfs(node.left, deque);
                dfs(node.right, deque);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return createTree(new ArrayDeque<>(Arrays.asList(data.split(","))));
        }

        private TreeNode createTree(Deque<String> deque) {
            if (deque.isEmpty()) return null;
            String data = deque.removeFirst();
            if (data.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(data));
            root.left = createTree(deque);
            root.right = createTree(deque);
            return root;
        }
    }
}
