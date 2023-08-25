package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6418
 * @since 2023/5/7 12:43
 */
public class Problem6418 {
    public static void main(String[] args) {

    }

    public int[] colorTheArray(int n, int[][] queries) {
        int m = queries.length, i = 0;
        int[] ans = new int[m], nums = new int[n];
        for (int[] query : queries) {
            int index = query[0], color = query[1];
            if (i > 0) ans[i] = ans[i - 1];
            if (index < n - 1 && nums[index] != 0 && nums[index] == nums[index + 1]) ans[i]--;
            if (index > 0 && nums[index] != 0 && nums[index] == nums[index - 1]) ans[i]--;
            if (index < n - 1 && nums[index + 1] != 0 && color == nums[index + 1]) ans[i]++;
            if (index > 0 && nums[index - 1] != 0 && color == nums[index - 1]) ans[i]++;
            nums[index] = color;
            i++;
        }
        return ans;
    }
}
