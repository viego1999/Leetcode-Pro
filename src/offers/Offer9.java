package offers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 链接：<a href="https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/">用两个栈实现队列</a>
 */
public class Offer9 {
    public static void main(String[] args) {

    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * <pre>{@code
     *  CQueue obj = new CQueue();
     *  obj.appendTail(value);
     *  int param_2 = obj.deleteHead();
     * }
     * </pre>
     */
    static class CQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()) return stack2.pop();
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
