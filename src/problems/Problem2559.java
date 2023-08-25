package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2559
 * @since 2023/6/2 9:45
 */
public class Problem2559 {
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
