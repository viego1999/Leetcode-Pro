package problems;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6472
 * @since 2023/6/4 10:53
 */
public class Problem6472 {
    public static void main(String[] args) {
        System.out.println((long) Math.pow(10, 22));
        System.out.println(Long.MAX_VALUE);
    }

    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> rows = new HashSet<>(), cols = new HashSet<>();
        long ans = 0;
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0], index = queries[i][1], val = queries[i][2];
            if (type == 0) {
                if (rows.contains(index)) continue;
                ans += val * (n - cols.size());
                rows.add(index);
            } else {
                if (cols.contains(index)) continue;
                ans += val * (n - rows.size());
                cols.add(index);
            }
        }
        return ans;
    }
}
