package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] p : people) {
            if (ans.size() <= p[1]) ans.add(p);
            else ans.add(p[1], p);
        }
        return ans.toArray(new int[0][0]);
    }
}
