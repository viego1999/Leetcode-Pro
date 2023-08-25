package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem6280 {

    public static void main(String[] args) {

    }

    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        int[] ans = {0, Integer.MAX_VALUE};
        for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime(i)) primes.add(i);
        }
        if (primes.size() < 2) return new int[]{-1, -1};
        for (int i = 1; i < primes.size(); i++) {
            int a = primes.get(i - 1), b = primes.get(i);
            if (ans[1] - ans[0] > b - a) {
                ans[0] = a;
                ans[1] = b;
            }
        }
        return ans;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
