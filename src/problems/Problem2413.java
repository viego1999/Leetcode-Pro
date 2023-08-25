package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2413
 * @since 2023/4/21 22:59
 */
public class Problem2413 {
    public static void main(String[] args) {

    }

    public int smallestEvenMultiple(int n) {
        return n * 2 / gcd(n, 2);
    }

    public int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
