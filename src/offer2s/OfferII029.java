package offer2s;

import util.Node;

/**
 * 剑指 Offer II 029. 排序的循环链表
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 *
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
 *
 *
 * 示例 2：
 *
 * 输入：head = [], insertVal = 1
 * 输出：[1]
 * 解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
 * 示例 3：
 *
 * 输入：head = [1], insertVal = 0
 * 输出：[1,0]
 *
 *
 * 提示：
 *
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 *
 * link: https://leetcode.cn/problems/4ueAj6/
 */
public class OfferII029 {
    public static void main(String[] args) {

    }

    public Node insert_(Node head, int insertVal) {
        Node min, max = head, p = head, node = new Node(insertVal);
        if (head == null) return node.next = node;
        while (p != null) {
            if (max.val <= p.val) max = p; // 找最后一个最大值
            if ((p = p.next) == head) break;
        }
        min = max.next; // 最小值等于 max.next
        if (insertVal <= min.val) {
            node.next = max.next;
            max.next = node;
        } else if (insertVal >= max.val) {
            node.next = max.next;
            max.next = node;
        } else {
            Node dummy = new Node(-0x3f3f3f3f, min), prev = dummy;
            while (prev.next != null && prev.next.val < insertVal) prev = prev.next;
            node.next = prev.next;
            prev.next = node;
        }
        return head;
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) return node.next = node;
        if (head.next == null) {
            head.next = node;
            node.next = head;
            return head;
        }
        // 找到第一个最小值first1，找到最后一个最小值first2
        Node first2 = head, p = head.next, first1;
        int min = head.val;
        while (p != head) {
            if (p.val <= min) {
                min = p.val;
                first2 = p;
            }
            p = p.next;
        }
        first1 = first2.next;
        while (first1.val != first2.val) first1 = first1.next;
        if (min <= insertVal) {
            p = first2;
            if (p.val != insertVal) {
                while (p.next.val < insertVal && p.next != first2) p = p.next;
                if (p.next == first2) {
                    p = first2.next;
                    while (p.next != first1) p = p.next;
                }
            }
        } else {
            p = first1;
            while (p.next != first1) p = p.next;
        }
        node.next = p.next;
        p.next = node;
        return head;
    }
}
