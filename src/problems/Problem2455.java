package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2455
 * @since 2023/5/29 10:05
 */
public class Problem2455 {
    public static void main(String[] args) {

    }

    public int averageValue(int[] nums) {
        int cnt = 0, sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                cnt++;
            }
        }
        return sum == 0 ? 0 : sum / cnt;
    }
}
