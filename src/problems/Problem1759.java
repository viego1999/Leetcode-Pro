package problems;

public class Problem1759 {
    public static void main(String[] args) {

    }

    public int countHomogenous_(String s) {
        long ans = 0;
        int mod = (int) 1e9 + 7, n = s.length(), l = 0, r = 0;
        char[] cs = s.toCharArray();
        while (l < n) {
            int k = 1; // k 表示和cs[i]重复的个数
            while (r < n && cs[l] == cs[r]) {
                ans += k++;
                r++;
            }
            l = r;
        }
        return (int) (ans % mod);
    }

    public int countHomogenous(String s) {
        long ans = 0;
        int mod = (int) 1e9 + 7, n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n;) {
            int j = i, k = 1; // k 表示和cs[i]重复的个数
            while (j < n && cs[j] == cs[i]) {
                ans += k++;
                j++;
            }
            i = j;
        }
        return (int) (ans % mod);
    }
}
