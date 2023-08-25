package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2418
 * @since 2023/4/25 0:33
 */
public class Problem2418 {
    public static void main(String[] args) {

    }

    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] idxs = new Integer[names.length];
        for (int i = 0; i < idxs.length; i++) idxs[i] = i;
        Arrays.sort(idxs, (a, b) -> heights[b] - heights[a]);
        String[] ans = new String[idxs.length];
        for (int i = 0; i < idxs.length; i++) ans[i] = names[idxs[i]];
        return ans;
    }
}
