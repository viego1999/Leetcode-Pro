package problems;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem297 {

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return sdfs(root, "");
        }

        public String sdfs(TreeNode root, String cur) {
            if (root == null) return cur + "null,";
            cur += root.val + ",";
            cur = sdfs(root.left, cur);
            cur = sdfs(root.right, cur);
            return cur;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> deque = new ArrayDeque<>(Arrays.asList(data.split(",")));
            return ddfs(deque);
        }

        public TreeNode ddfs(Deque<String> deque) {
            String first = deque.removeFirst();
            if (first.equals("null")) return null;
            TreeNode root = new TreeNode(Integer.parseInt(first));
            root.left = ddfs(deque);
            root.right = ddfs(deque);
            return root;
        }
    }
}
