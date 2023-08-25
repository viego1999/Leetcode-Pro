package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2423
 * @since 2023/4/29 14:51
 */
public class Problem2423 {
    public static void main(String[] args) {

    }

    public boolean equalFrequency(String word) {
        char[] cs = word.toCharArray();
        int[] cnts = new int[26];
        int max = 0, cnt = 0, n = cs.length;
        for (char c : cs) {
            if (++cnts[c - 'a'] > max) {
                max = cnts[c - 'a'];
                cnt = 1;
            } else if (cnts[c - 'a'] == max) cnt++;
        }
        if (n - max * cnt == 1 || max == 1) return true;
        for (int c : cnts) if (c != 0 && max - c > 1) return false;
        return cnt == 1;
    }
}
