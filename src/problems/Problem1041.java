package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1041
 * @since 2023/4/11 12:45
 */
public class Problem1041 {
    public static void main(String[] args) {

    }

    public boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') d = (d - 1 + 4) % 4;
            else if (c == 'R') d = (d + 1) % 4;
            else {
                x += dirs[d][0];
                y += dirs[d][1];
            }
        }
        return d != 0 || (x == 0 && y == 0);
    }

    public boolean isRobotBounded_(String instructions) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0;
        for (int i = 0; i < 4; i++) {
            for (char c : instructions.toCharArray()) {
                if (c == 'L') d = (d - 1 + 4) % 4;
                else if (c == 'R') d = (d + 1) % 4;
                else {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }
            if (x == 0 && y == 0) return true;
        }
        return false;
    }
}
