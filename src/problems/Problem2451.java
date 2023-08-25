package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2451
 * @since 2023/5/25 10:40
 */
public class Problem2451 {
    public static void main(String[] args) {

    }

    public String oddString(String[] words) {
        int n = words.length, t = 0;
        int[][] arrs = new int[n][];
        for (String word : words) {
            int[] arr = new int[word.length() - 1];
            for (int i = 1; i < word.length(); i++) {
                arr[i - 1] = word.charAt(i) - word.charAt(i - 1);
            }
            arrs[t++] = arr;
        }
        for (int i = 1; i < n; i++) {
            if (!Arrays.equals(arrs[i - 1], arrs[i])) {
                if (i == n - 1) {
                    return Arrays.equals(arrs[i], arrs[i - 2]) ? words[i - 1] : words[i];
                } else {
                    return Arrays.equals(arrs[i], arrs[i + 1]) ? words[i - 1] : words[i];
                }
            }
        }
        return "";
    }
}
