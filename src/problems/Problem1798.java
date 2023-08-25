package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1798
 * @since 2023/2/4 11:14
 */
public class Problem1798 {
    public static void main(String[] args) {

    }

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int sum = 0, next = 1;
        for (int coin : coins) {
            if (coin <= next) {
                sum += coin;
                next = sum + 1;
            } else break;
        }
        return sum + 1;
    }
}
