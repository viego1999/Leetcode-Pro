package problems;

import java.util.Arrays;

/**
 * 828. 统计子串中的唯一字符
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 *
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 *
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
 *
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "ABC"
 * 输出: 10
 * 解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
 *      其中，每一个子串都由独特字符构成。
 *      所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
 * 示例 2：
 *
 * 输入: s = "ABA"
 * 输出: 8
 * 解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
 * 示例 3：
 *
 * 输入：s = "LEETCODE"
 * 输出：92
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 只包含大写英文字符
 *
 * link: https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 */
public class Problem828 {
    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC"));
        System.out.println(uniqueLetterString("ABA"));
        System.out.println(uniqueLetterString("LEETCODE"));
        System.out.println(uniqueLetterString("DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU"));
        System.out.println(uniqueLetterString("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
    }

    public static int uniqueLetterString(String s) {
        int n = s.length(), ans = 0;
        int[] last = new int[26], curr = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(curr, -1);
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int j = cs[i] - 'A';
            if (curr[j] != -1) ans += (curr[j] - last[j]) * (i - curr[j]);
            last[j] = curr[j];
            curr[j] = i;
        }
        for (int i = 0; i < 26; i++) {
            if (curr[i] > -1) ans += (curr[i] - last[i]) * (n - curr[i]);
        }
        return ans;
    }

    public static int uniqueLetterStringBF(String s) {
        int n = s.length(), ans = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ans += helper(cs, i, j);
            }
        }
        return ans;
    }

    public static int helper(char[] cs, int l, int r) {
        int[] hash = new int[26];
        int ans = 0;
        for (int i = l; i <= r; i++) {
            int cur = ++hash[cs[i] - 'A'];
            if (cur == 1) ans++;
            else if (cur == 2) ans--;
        }
        return ans;
    }
}
