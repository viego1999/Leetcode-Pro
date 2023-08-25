package offer2s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII015
 * @since 2023/4/6 18:12
 */
public class OfferII015 {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cnts1 = new int[26], cnts2 = new int[26];
        for (char c : p.toCharArray()) cnts1[c - 'a']++;
        char[] cs = s.toCharArray();
        int n = cs.length, l = 0, r = 0, i;
        while (r < n) {
            cnts2[i = (cs[r++] - 'a')]++;
            while (cnts1[i] < cnts2[i]) cnts2[cs[l++] - 'a']--;
            if (Arrays.equals(cnts1, cnts2)) ans.add(l);
        }
        return ans;
    }
}
