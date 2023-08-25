package util;

/**
 * Multi level list class.
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName MNode
 * @since 2023/4/12 22:13
 */
public class MNode {
    public int val;
    public MNode prev;
    public MNode next;
    public MNode child;

    public MNode(int _val) {
        this.val = _val;
    }

    public MNode(int _val, MNode _next) {
        this.val = _val;
        this.next = _next;
    }
}
