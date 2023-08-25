package problems;

public class Problem1768 {
    public static void main(String[] args) {

    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0, k = 0, m = word1.length(), n = word2.length();
        while (i < m && j < n) {
            if ((k++ & 1) == 0) sb.append(word1.charAt(i++));
            else sb.append(word2.charAt(j++));
        }
        if (i < m) sb.append(word1, i, m);
        if (j < n) sb.append(word2, j, n);
        return sb.toString();
    }
}
