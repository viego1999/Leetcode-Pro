package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2465
 * @since 2023/6/4 9:36
 */
public class Problem2465 {
    public static void main(String[] args) {

    }

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, i = 0, j = n - 1;
        Set<Double> set = new HashSet<>();
        while (i < j) set.add((nums[i++] + nums[j--]) / 2.);
        return set.size();
    }
}
