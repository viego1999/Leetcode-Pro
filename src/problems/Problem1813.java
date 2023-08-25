package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1813
 * @since 2023/1/16 10:59
 */
public class Problem1813 {

    public static void main(String[] args) {

    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" "), s2 = sentence2.split(" ");
        if (s1.length < s2.length) return areSentencesSimilar(sentence2, sentence1);
        int i = 0, j = 0, n1 = s1.length, n2 = s2.length, k = n1 - 1, l = n2 - 1;
        while (j < n2 && s1[i].equals(s2[j])) i = ++j;
        while (l >= j && s1[k].equals(s2[l])) {
            k--;
            l--;
        }
        return j > l;
    }
}
