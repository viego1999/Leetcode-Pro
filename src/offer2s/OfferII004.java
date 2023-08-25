package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII004
 * @since 2023/3/4 22:19
 */
public class OfferII004 {
    public static void main(String[] args) {

    }

    // x ^ 0 = x
    // x ^ x = 0
    // x & ~x = 0
    // x & ~0 = x
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }
}
