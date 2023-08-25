package offer2s;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII046
 * @since 2023/5/1 13:31
 */
public class OfferII046 {
    public static void main(String[] args) {

    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (ans.size() == level) ans.add(node.val);
        else ans.set(level, node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
