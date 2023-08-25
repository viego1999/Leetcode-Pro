package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII032
 * @since 2023/4/25 22:21
 */
public class OfferII032 {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;
        int[] hash = new int[26], hash1;
        for (char c : s.toCharArray()) hash[c - 'a']++;
        for (char c : t.toCharArray()) {
            if (--hash[c - 'a'] < 0) return false;
        }
        return true;
    }
}
