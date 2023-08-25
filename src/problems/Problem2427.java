package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2427
 * @since 2023/4/5 0:28
 */
public class Problem2427 {
    public static void main(String[] args) {

    }

    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int i = 1, j = gcd(a, b); i <= j; i++) {
            if (a % i == 0 && b % i == 0) ans++;
        }
        return ans;
    }

    public int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
