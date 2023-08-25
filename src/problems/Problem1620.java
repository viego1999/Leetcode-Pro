package problems;

import java.util.Arrays;

public class Problem1620 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bestCoordinate(new int[][]{{1, 2, 5}, {2, 1, 7}, {3, 1, 9}}, 2)));
    }

    public static int[] bestCoordinate(int[][] towers, int radius) {
        int[] ans = new int[2];
        int max = 0, xMin = 50, yMin = 50, xMax = 0, yMax = 0, radius2 = radius * radius;
        for (int[] tower : towers) {
            xMin = Math.min(xMin, tower[0]);
            yMin = Math.min(yMin, tower[1]);
            xMax = Math.max(xMax, tower[0]);
            yMax = Math.max(yMax, tower[1]);
        }
        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMin; y <= yMax; y++) {
                int q = 0;
                for (int[] tower : towers) {
                    int d = (x - tower[0]) * (x - tower[0]) + (y - tower[1]) * (y - tower[1]);
                    if (d > radius2) continue;
                    q += Math.floor(tower[2] / (1 + Math.sqrt(d)));
                }
                if (q > max) {
                    ans[0] = x;
                    ans[1] = y;
                    max = q;
                }
            }
        }
        return ans;
    }
}
