package problems;

public class Problem6266 {
    public static void main(String[] args) {
        System.out.println(smallestValue(99999));
    }

    public static int smallestValue(int n) {
        while (true) {
            int t = 0, n0 = n;
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    t += i;
                    n /= i;
                }
            }
            if (n0 == t) return t;
            n = t;
        }
    }

    public static int smallestValue_(int n) {
        while (!isPrime(n)) {
            int t = 0, n0 = n;
            for (int i = 2; i <= n; i++) {
                while (n % i == 0) {
                    t += i;
                    n /= i;
                }
            }
            if (n0 == t) return t;
            n = t;
        }
        return n;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
