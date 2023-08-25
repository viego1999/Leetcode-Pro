package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 735. 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 *
 *
 * 示例 1：
 *
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 *
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 *
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 *
 * 提示：
 *
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *
 * link: https://leetcode.cn/problems/asteroid-collision/
 */
public class Problem735 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, -1, 1, 2})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{2, 1, -1, -2})));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i, top;
        for (int asteroid : asteroids) { // +往右，-往左
            if (asteroid > 0) stack.push(asteroid);
            else {
                boolean add = true;
                while (add && !stack.isEmpty() && (top = stack.peek()) > 0) {
                    add = top < -asteroid;
                    if (top <= -asteroid) stack.pop();
                }
                if (add) stack.push(asteroid);
            }
        }
        int[] ans = new int[(i = stack.size())];
        while (!stack.isEmpty()) ans[--i] = stack.pop();
        return ans;
    }
}
