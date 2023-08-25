package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem822
 * @since 2023/8/3 1:20
 */
public class Problem822 {
    public static void main(String[] args) {

    }

    public int flipgame(int[] fronts, int[] backs) {
        int ans = 0x3f3f3f3f, n = fronts.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) if (fronts[i] == backs[i]) set.add(fronts[i]);
        for (int front : fronts) if (!set.contains(front)) ans = Math.min(ans, front);
        for (int back : backs) if (!set.contains(back)) ans = Math.min(ans, back);
        return ans == 0x3f3f3f3f ? 0 : ans;
    }

    public int flipgame_(int[] fronts, int[] backs) {
        int ans = 0x3f3f3f3f, n = fronts.length;
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) continue;
            boolean flag1 = true, flag2 = true;
            for (int j = 0; j < i && (flag1 || flag2); j++) {
                if (fronts[i] == fronts[j] && fronts[i] == backs[j]) flag1 = false;
                if (backs[i] == fronts[j] && backs[i] == backs[j]) flag2 = false;
            }
            for (int j = i + 1; j < n && (flag1 || flag2); j++) {
                if (fronts[i] == fronts[j] && fronts[i] == backs[j]) flag1 = false;
                if (backs[i] == fronts[j] && backs[i] == backs[j]) flag2 = false;
            }
            if (flag1) ans = Math.min(ans, fronts[i]);
            if (flag2) ans = Math.min(ans, backs[i]);
        }
        return ans == 0x3f3f3f3f ? 0 : ans;
    }
}
