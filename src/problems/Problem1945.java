package problems;

public class Problem1945 {
    public static void main(String[] args) {

    }

    public int getLucky(String s, int k) {
        int ans = 0, t;
        for (char c : s.toCharArray()) {
            t = c - 'a' + 1;
            ans += t / 10 + t % 10;
        }
        while (--k > 0) {
            for (t = 0; ans > 0; ans /= 10) t += ans % 10;
            if ((ans = t) < 10) return ans;
        }
        return ans;
    }
}
