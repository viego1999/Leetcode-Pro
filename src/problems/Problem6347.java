package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6347
 * @since 2023/2/5 17:16
 */
public class Problem6347 {
    public static void main(String[] args) {

    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length, m = queries.length;
        int[] sums = new int[n + 1], ans = new int[m];
        String str = "aeiou";
        for (int i = 1; i <= n; i++)
            sums[i] = sums[i - 1] + (str.indexOf(words[i - 1].charAt(0)) != -1 &&
                    str.indexOf(words[i - 1].charAt(words[i - 1].length() - 1)) != -1 ? 1 : 0);
        for (int i = 0; i < m; i++) ans[i] = sums[queries[i][1] + 1] - sums[queries[i][0]];
        return ans;
    }
}
