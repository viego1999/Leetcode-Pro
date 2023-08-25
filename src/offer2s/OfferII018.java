package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII018
 * @since 2023/4/6 19:24
 */
public class OfferII018 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        int n = s.length(), l = 0, r = n - 1;
        s = s.toLowerCase();
        char[] cs = s.toCharArray();
        while (l < r) {
            while (l < r && !(Character.isLetter(cs[l]) || Character.isDigit(cs[l]))) l++;
            while (l < r && !(Character.isLetter(cs[r]) || Character.isDigit(cs[r]))) r--;
            if (l < r && cs[l++] != cs[r--]) return false;
        }
        return true;
    }
}
