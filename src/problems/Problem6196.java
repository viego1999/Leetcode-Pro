package problems;

public class Problem6196 {

    public static void main(String[] args) {

    }

    public static int minimumPartition(String s, int k) {
        char[] cs = s.toCharArray();
        int ans = 0, n = s.length();
        for (char c : cs) if (c - '0' > k) return -1;
        for (int i = 0; i < n;) {
            int j = i, t = cs[i] - '0';
            while (t <= k && j < n - 1) {
                long m = t * 10L + cs[j + 1] - '0';
                if (m <= k) {
                    j++;
                    t = (int) m;
                } else break;
            }
            i = j + 1;
            ans++;
        }
        return ans;
    }

}
