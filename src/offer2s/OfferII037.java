package offer2s;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII037
 * @since 2023/4/29 23:32
 */
public class OfferII037 {
    public static void main(String[] args) {

    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster; // aster 是否存在
                if (stack.peek() <= -aster) {  // 栈顶小行星爆炸
                    stack.pop();
                }
            }
            if (alive) stack.push(aster);
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) ans[i] = stack.pop();
        return ans;
    }
}
