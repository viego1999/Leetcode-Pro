package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2404
 * @since 2023/4/13 11:12
 */
public class Problem2404 {
    public static void main(String[] args) {

    }

    public int mostFrequentEven(int[] nums) {
        int[] hash = new int[100005];
        int max = -1, cnt = 0;
        for (int num : nums) {
            if ((num & 1) == 0 && ++hash[num] >= cnt) {
                if (hash[num] > cnt || num < max) {
                    max = num;
                    cnt = hash[num];
                }
            }
        }
        return max;
    }
}
