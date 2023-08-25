package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2325
 * @since 2023/2/1 0:11
 */
public class Problem2325 {
    public static void main(String[] args) {

    }

    public String decodeMessage(String key, String message) {
        int[] hash = new int[26];
        Arrays.fill(hash, -1);
        int i = 'a', idx;
        for (char c : key.toCharArray()) {
            idx = c - 'a';
            if (c != ' ' && hash[idx] == -1) hash[idx] = i++;
        }
        char[] cs = message.toCharArray();
        for (i = 0; i < cs.length; i++) {
            if (cs[i] != ' ') cs[i] = (char) hash[cs[i] - 'a'];
        }
        return new String(cs);
    }
}
