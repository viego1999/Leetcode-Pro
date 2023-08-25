package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6441
 * @since 2023/5/21 10:47
 */
public class Problem6441 {
    public static void main(String[] args) {

    }

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int pow = i * i;
            if (dfs(String.valueOf(pow).toCharArray(), 0, i)) ans += pow;
        }
        return ans;
    }

    public boolean dfs(char[] cs, int t, int sum) {
        if (sum < 0) return false;
        if (t == cs.length) return sum == 0;
        for (int i = t, num = 0; i < cs.length; i++) {
            if (i > t && cs[t] == '0') break;
            num = num * 10 + (cs[i] - '0');
            if (dfs(cs, i + 1, sum - num)) return true;
        }
        return false;
    }
}
