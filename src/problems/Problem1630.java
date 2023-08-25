package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1630
 * @since 2023/3/23 14:48
 */
public class Problem1630 {
    public static void main(String[] args) {

    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(arr);
            boolean flag = true;
            for (int j = 2; j < arr.length && flag; j++) {
                if (arr[j] - arr[j - 1] != arr[j - 1] - arr[j - 2]) flag = false;
            }
            ans.add(flag);
        }
        return ans;
    }
}
