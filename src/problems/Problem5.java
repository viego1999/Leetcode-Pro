package problems;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 来源：力扣（LeetCode）
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem5 {
    public static void main(String[] args) {
        String longSting1000 = "";
        for (int i = 0; i < 100; i++) {
            longSting1000 += "z";
        }

        long start = System.currentTimeMillis();
        System.out.println(longestPalindrome(longSting1000));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    /*
     *  answer-1: Brute force method
     */
    public static String longestPalindrome(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i).length() > ans.length()) {
                String str = getPalindrome(s.substring(i));
                ans = str.length() > ans.length() ? str : ans;
            }
        }

        return ans;
    }

    public static String getPalindrome(String s) {
        String str = "";
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (str.length() > 0 && str.charAt(0) == s.charAt(i)) {
                str += "" + s.charAt(i);
                if (str.length() > ans.length() && isPalindrome(str)) {
                    ans = str;
                }
            } else {
                str += "" + s.charAt(i);
                if (i == s.length() - 1)
                    ans = ans.length() < 1 ? str.charAt(0) + "" : ans; // arrive at the end of string
            }
        }

        return ans;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /*
     * answer-2: Central diffusion method
     */
    public static String longestPalindrome_(String s) {
        if (s.length() == 0) return "";
        int[] range = new int[2];

        for (int i = 0; i < s.length(); i++) {
            // 对于偶数长度的回文（如 "abba"），其中心是一段连续相同的字符。
            // 无论选这段字符里的哪一个作为起点，最终向两边扩展得到的最大回文串都是一样的
            i = findLongest(s, i, range);
        }

        return s.substring(range[0], range[1] + 1);
    }

    // b a n a n a s
    public static int findLongest(String s, int low, int[] range) {
        int high = low;
        // search the position of the same char as the low-th
        while (high < s.length() - 1 && s.charAt(high + 1) == s.charAt(low)) {
            high++;
        }

        int ans = high;
        while (low > 0 && high < s.length() - 1 && s.charAt(low - 1) == s.charAt(high + 1)) {
            low--;
            high++;
        }

        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }

        return ans;
    }

    // judge whether the str is palindrome
    public static boolean judgePalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean judgePalindrome_(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static boolean judgePalindrome(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static String longestPalindromeDp(String s) {
        if (s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] range = new int[2];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j] && j - i + 1 > range[1] - range[0]) {
                    range[0] = i;
                    range[1] = j;
                }
            }
        }

        return s.substring(range[0], range[1] + 1);
    }
}
