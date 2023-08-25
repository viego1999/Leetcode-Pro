package offer2s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII074
 * @since 2023/5/11 15:28
 */
public class OfferII074 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length, l = intervals[0][0], r = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > r) {
                ans.add(new int[]{l, r});
                l = intervals[i][0];
            }
            r = Math.max(r, intervals[i][1]);
        }
        ans.add(new int[]{l, r});
        return ans.toArray(new int[ans.size()][]);
    }
}
