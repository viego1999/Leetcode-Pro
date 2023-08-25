package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1010
 * @since 2023/5/7 9:55
 */
public class Problem1010 {
    public static void main(String[] args) {

    }

    public int numPairsDivisibleBy60(int[] time) {
        int[] hash = new int[60];
        int ans = 0;
        for (int t : time) {
            ans += hash[(60 - t % 60) % 60];
            hash[t % 60]++;
        }
        return ans;
    }
}
