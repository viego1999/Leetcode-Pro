package offer2s;

import util.MNode;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII028
 * @since 2023/4/12 22:12
 */
public class OfferII028 {
    public static void main(String[] args) {

    }

    MNode dummy = new MNode(-1), p = dummy;

    public MNode flatten(MNode head) {
        if (head == null) return null;
        dfs(head);
        dummy.next.prev = null;
        return dummy.next;
    }

    public void dfs(MNode node) {
        if (node == null) return;
        p.next = node;
        node.prev = p;
        p = p.next;
        MNode next = node.next, child = node.child;
        node.child = null;
        dfs(child);
        dfs(next);
    }
}
