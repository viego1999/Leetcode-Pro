package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2335
 * @since 2023/2/11 0:25
 */
public class Problem2335 {
    public static void main(String[] args) {

    }

    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        // 用a2可以同时取完a0和a1
        if (amount[2] > amount[0] + amount[1]) return amount[2];
        // 向上取整
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
