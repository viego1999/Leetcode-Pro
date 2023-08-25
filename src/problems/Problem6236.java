package problems;

public class Problem6236 {
    public static void main(String[] args) {
        System.out.println(maxPalindromes("abaccdbbd", 3));
    }

    public static int maxPalindromes(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] flag = new boolean[n][n];
        int[] dp = new int[n + 1]; // dp[i]长度为i的前缀中长度不小于k的子字符串个数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int l = i, r = i + j;
                while (l >= 0 && r < n && cs[l--] == cs[r++]) flag[l + 1][r - 1] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = i - k; j >= 0; j--) {
                if (flag[j][i - 1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp[n];
    }

    public int maxPalindromes_(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] dp = new int[n + 1];
        for (char i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = l + i % 2; // 中心扩展法
            dp[l + 1] = Math.max(dp[l + 1], dp[l]);
            for (; l >= 0 && r < n && cs[l] == cs[r]; --l, ++r)
                if (r - l + 1 >= k)
                    dp[r + 1] = Math.max(dp[r + 1], dp[l] + 1);
        }
        return dp[n];
    }
}
