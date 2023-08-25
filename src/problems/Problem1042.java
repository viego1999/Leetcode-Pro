package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1042
 * @since 2023/4/16 11:45
 */
public class Problem1042 {
    public static void main(String[] args) {

    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        List<Integer>[] adjs = new ArrayList[n];
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for (int[] path : paths) {
            adjs[path[0] - 1].add(path[1] - 1);
            adjs[path[1] - 1].add(path[0] - 1);
        }
        for (int i = 0; i < n; i++) {
            int state = 0;
            for (int next : adjs[i]) state |= 1 << ans[next];
            for (int j = 1; j <= 4; j++) {
                if (((state >> j) & 1) == 0) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
