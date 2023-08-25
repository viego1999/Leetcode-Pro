package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2341
 * @since 2023/2/16 10:02
 */
public class Problem2341 {
    public static void main(String[] args) {

    }

    public int[] numberOfPairs(int[] nums) {
        int[] ans = new int[2], cnts = new int[101];
        for (int num : nums) ++cnts[num];
        for (int i = 0; i < 101; i++) {
            ans[0] += cnts[i] / 2;
            ans[1] += cnts[i] & 1;
        }
        return ans;
    }
}
