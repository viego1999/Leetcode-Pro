package problems;

import java.util.Arrays;

public class Problem791 {
    public static void main(String[] args) {
        System.out.println(customSortString__("hucw",
                "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh"));
    }

    public static String customSortString__(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] hash = new int[26], cnts = new int[26];
        char[] os = order.toCharArray(), cs = s.toCharArray();
        for (int i = 0; i < os.length; ) hash[os[i] - 'a'] = ++i;
        for (char c : cs) cnts[c - 'a']++;
        for (char c : os) {
            for (int i = 0, n = cnts[c - 'a']; i < n; i++) sb.append(c);
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] == 0)
                for (int j = 0, n = cnts[i]; j < n; j++) sb.append((char)(i + 'a'));
        }
        return sb.toString();
    }

    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] cnts = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) cnts[c - 'a']++;
        for (char c : order.toCharArray()) {
            while (cnts[c - 'a']-- > 0) sb.append(c);
        }
        for (char c : cs) {
            while (cnts[c - 'a']-- > 0) sb.append(c);
        }
        return sb.toString();
    }

    public String customSortString_(String order, String s) {
        int[] hash = new int[26];
        char[] os = order.toCharArray(), tmp = s.toCharArray();
        Character[] cs = new Character[s.length()];
        for (int i = 0; i < os.length; i++) {
            hash[os[i] - 'a'] = i + 1;
        }
        for (int i = 0; i < tmp.length; i++) {
            cs[i] = tmp[i];
        }
        Arrays.sort(cs, (x, y) -> hash[x - 'a'] - hash[y - 'a']);
        StringBuilder sb = new StringBuilder();
        for (char c : cs) sb.append(c);
        return sb.toString();
    }
}
