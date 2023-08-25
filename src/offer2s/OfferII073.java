package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII073
 * @since 2023/5/15 22:33
 */
public class OfferII073 {
    public static void main(String[] args) {

    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = (int) 1e9 + 7;
        while (l < r) {
            int m = l + r >> 1, t = 0;
            for (int pile : piles) t += (m - 1 + pile) / m;
            if (t > h) l = m + 1;
            else r = m;
        }
        return l;
    }
}
