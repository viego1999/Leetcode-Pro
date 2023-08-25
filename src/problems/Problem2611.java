package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2611
 * @since 2023/6/7 10:21
 */
public class Problem2611 {
    public static void main(String[] args) {

    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length, ans = 0;
        Integer[] idxs = new Integer[n];
        for (int i = 0; i < n; i++) idxs[i] = i;
        Arrays.sort(idxs, (i, j) -> (reward1[j] - reward2[j]) - (reward1[i] - reward2[i]));
        for (int i = 0; i < k; i++) ans += reward1[idxs[i]];
        for (int i = k; i < n; i++) ans += reward2[idxs[i]];
        return ans;
    }
}
