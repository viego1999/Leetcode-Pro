package offer2s;

import java.util.Random;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII071
 * @since 2023/5/15 21:58
 */
public class OfferII071 {
    public static void main(String[] args) {

    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
    static class Solution {
        int[] sums;
        Random random = new Random();

        public Solution(int[] w) {
            sums = new int[w.length];
            sums[0] = w[0];
            for (int i = 1; i < w.length; i++) sums[i] = sums[i - 1] + w[i];
        }

        public int pickIndex() {
            int n = sums.length, l = 0, r = n - 1;
            int t = random.nextInt(sums[n - 1]) + 1;
            while (l < r) {
                int m = l + r >> 1;
                if (sums[m] < t) l = m + 1;
                else r = m;
            }
            return l;
        }
    }
}
