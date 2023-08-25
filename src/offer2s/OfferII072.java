package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII072
 * @since 2023/5/15 22:13
 */
public class OfferII072 {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            long m = l + r + 1L >> 1;
            if (m * m <= x) l = (int) m;
            else r = (int) (m - 1);
        }
        return l;
    }
}
