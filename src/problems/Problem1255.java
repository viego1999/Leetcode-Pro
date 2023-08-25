package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1255
 * @since 2023/2/26 22:01
 */
public class Problem1255 {
    public static void main(String[] args) {

    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] cnts = new int[26];
        for (char c : letters) cnts[c - 'a']++;
        return backtrack(words, score, cnts, 0, 0);
    }

    public int backtrack(String[] words, int[] score, int[] cnts, int sum, int idx) {
        if (idx == words.length) return sum;
        int t1, t2, s1 = 0;
        t1 = backtrack(words, score, cnts, sum, idx + 1);
        int[] tmps = new int[26];
        for (char c : words[idx].toCharArray()) if (++tmps[c - 'a'] > cnts[c - 'a']) return t1;
        for (int i = 0; i < 26; i++) {
            s1 += tmps[i] * score[i];
            cnts[i] -= tmps[i];
        }
        t2 = backtrack(words, score, cnts, sum + s1, idx + 1);
        for (int i = 0; i < 26; i++) cnts[i] += tmps[i]; // 恢复现场
        return Math.max(t1, t2);
    }
}
