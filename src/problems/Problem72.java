package problems;

/**
 * 72. 编辑距离 （字节）
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * <p>
 * 删除一个字符
 * <p>
 * 替换一个字符
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * horse -> rorse (将 'h' 替换为 'r')
 * <p>
 * rorse -> rose (删除 'r')
 * <p>
 * rose -> ros (删除 'e')
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * intention -> inention (删除 't')
 * <p>
 * inention -> enention (将 'i' 替换为 'e')
 * <p>
 * enention -> exention (将 'n' 替换为 'x')
 * <p>
 * exention -> exection (将 'n' 替换为 'c')
 * <p>
 * exection -> execution (插入 'u')
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * <p>
 * word1 和 word2 由小写英文字母组成
 * <p>
 * 链接：<a href="https://leetcode-cn.com/problems/edit-distance/">编辑距离</a>
 */
public class Problem72 {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    /*
        1、状态定义：
        dp[i][j]表示word1的前i个字母转换成word2的前j个字母所使用的最少操作。

        2、状态转移：
        i指向word1，j指向word2
        若当前字母相同，则dp[i][j] = dp[i - 1][j - 1];
        否则取增删替（对word1）三个操作的最小值 + 1， 即:
        dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1。
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    // 插入一个字符（word1插入相当于word2删除），删除一个字符，替换一个字符
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
