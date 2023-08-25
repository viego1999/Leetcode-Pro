package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII005
 * @since 2023/3/5 21:36
 */
public class OfferII005 {
    public static void main(String[] args) {

    }

    public int maxProduct(String[] words) {
        int n = words.length, ans = 0;
        int[] hash = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray())
                hash[i] |= 1 << (c - 'a');
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((hash[i] & hash[j]) == 0)
                    ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
