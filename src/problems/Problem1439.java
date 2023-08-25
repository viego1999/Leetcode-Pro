package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1439
 * @since 2023/5/28 20:23
 */
public class Problem1439 {
    public static void main(String[] args) {

    }

    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length, ans = 0;
        int[] temp = new int[m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < m; i++) {
                sum1 += mat[i][x[i]];
                sum2 += mat[i][y[i]];
            }
            return sum1 - sum2;
        });
        pq.offer(new int[m]);
        Set<String> set = new HashSet<>();
        set.add(Arrays.toString(new int[m]));
        while (k-- > 0 && !pq.isEmpty()) {
            temp = pq.poll();
            for (int i = 0; i < m; i++) {
                if (temp[i] + 1 < n) {
                    int[] clone = temp.clone();
                    clone[i]++;
                    if (set.add(Arrays.toString(clone))) {
                        pq.offer(clone);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) ans += mat[i][temp[i]];
        return ans;
    }
}
