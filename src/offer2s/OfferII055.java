package offer2s;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII055
 * @since 2023/5/3 13:07
 */
public class OfferII055 {
    public static void main(String[] args) {

    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    static class BSTIterator {
        TreeNode curr;
        Deque<TreeNode> stack = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            this.curr = root;
        }

        public int next() {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            int ans = curr.val;
            curr = curr.right;
            return ans;
        }

        public boolean hasNext() {
            return curr != null || !stack.isEmpty();
        }
    }
}
