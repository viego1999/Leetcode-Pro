package util;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 四叉树
 *
 * @author wxy
 * @see FNode
 * @since 1.0
 */
public class FNode {
    public boolean val;
    public boolean isLeaf;
    public FNode topLeft;
    public FNode topRight;
    public FNode bottomLeft;
    public FNode bottomRight;

    public FNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public FNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public FNode(boolean val, boolean isLeaf, FNode topLeft, FNode topRight, FNode bottomLeft, FNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<FNode> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                FNode node = queue.poll();
                assert node != null;
                stringBuilder.append("[").append(node.isLeaf ? 1 : 0).append(",").append(node.val ? 1 : 0).append("], ");
                if (!node.isLeaf) {
                    if (node.topLeft != null) queue.offer(node.topLeft);
                    if (node.topRight != null) queue.offer(node.topRight);
                    if (node.bottomLeft != null) queue.offer(node.bottomLeft);
                    if (node.bottomRight != null) queue.offer(node.bottomRight);
                }
            }
        }
        return "[" + stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()) + "]";
    }
}
