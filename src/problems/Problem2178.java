package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2178
 * @since 2023/7/6 23:26
 */
public class Problem2178 {
    public static void main(String[] args) {

    }

    public List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) == 1) return new ArrayList<>();
        List<Long> ans = new ArrayList<>();
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
        return ans;
    }
}
