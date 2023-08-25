package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2367
 * @since 2023/3/31 16:43
 */
public class Problem2367 {
    public static void main(String[] args) {

    }

    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] hash = new boolean[300];
        int ans = 0;
        for (int num : nums) hash[num] = true;
        for (int i : nums) {
            int j = i + diff, k = 2 * j - i;
            if (hash[j] && hash[k]) ans++;
        }
        return ans;
    }
}
