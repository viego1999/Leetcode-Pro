package offer2s;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII014
 * @since 2023/4/6 17:58
 */
public class OfferII014 {
    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        char[] cs = s2.toCharArray();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (char c : s1.toCharArray()) cnt1[c - 'a']++;
        int n = s2.length(), l = 0, r = 0, i;
        while (r < n) {
            cnt2[i = (cs[r++] - 'a')]++;
            while (cnt2[i] > cnt1[i]) cnt2[cs[l++] - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }
}
