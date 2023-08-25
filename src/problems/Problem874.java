package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem874
 * @since 2023/7/24 0:32
 */
public class Problem874 {
    public static void main(String[] args) {

    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0, x = 0, y = 0, d = 0, base = (int) (1e5 + 5);
        Set<Integer> set = new HashSet<>();
        for (int[] obstacle : obstacles) set.add(base * obstacle[0] + obstacle[1]);
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int command : commands) {
            if (command == -1) d = (d + 1) % 4;
            else if (command == -2) d = (d - 1 + 4) % 4;
            else {
                for (int i = 0; i < command; i++) {
                    int nx = x + dirs[d][0], ny = y + dirs[d][1];
                    if (set.contains(nx * base + ny)) break;
                    x = nx;
                    y = ny;
                }
            }
            ans = Math.max(ans, x * x + y * y);
        }
        return ans;
    }
}
