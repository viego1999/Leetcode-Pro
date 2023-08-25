package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII034
 * @since 2023/4/26 0:15
 */
public class OfferII034 {
    public static void main(String[] args) {

    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] idxs = new int[26];
        char[] cs = order.toCharArray();
        for (int i = 0; i < cs.length; i++) idxs[cs[i] - 'a'] = i;
        for (int i = 1, n = words.length; i < n; i++) {
            char[] cs1 = words[i - 1].toCharArray(), cs2 = words[i].toCharArray();
            int j = 0, k = -1, n1 = cs1.length, n2 = cs2.length;
            for (; j < n1 && j < n2 && k == -1; j++) {
                int a = idxs[cs1[j] - 'a'], b = idxs[cs2[j] - 'a'];
                if (a > b) return false;
                else if (a < b) k = 0;
            }
            if (k == -1 && n1 > n2) return false;
        }
        return true;
    }
}
