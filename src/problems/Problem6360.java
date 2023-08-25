package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6360
 * @since 2023/2/18 23:36
 */
public class Problem6360 {
    public static void main(String[] args) {

    }

    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        for (int i = 1; ; i *= 2) {
            if (!set.contains(i)) return i;
        }
    }
}
