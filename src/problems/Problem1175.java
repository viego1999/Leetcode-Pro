package problems;

import java.util.Arrays;

public class Problem1175 {
    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(5));
//        System.out.println(numPrimeArrangements(12));
//        System.out.println(numPrimeArrangements(100));
    }

    static int mod = (int) 1e9 + 7;

    public static int numPrimeArrangements(int n) {
        boolean[] isPrimes = new boolean[n + 5];
        Arrays.fill(isPrimes, true);
        int ans = 0, cnt = 0, rest = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrimes[i]) {
                cnt++;
                for (int j = i * i; j <= n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        ans += (cal(cnt) * cal(n - cnt)) % mod;
        return ans;
    }

    public static long cal(int n) {
        if (n == 0) return 1;
        return n * cal(n - 1) % mod;
    }
}
