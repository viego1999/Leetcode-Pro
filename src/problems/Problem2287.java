package problems;

public class Problem2287 {

    public int rearrangeCharacters(String s, String target) {
        int[] hash1 = new int[26], hash2 = new int[26];
        for (char c : s.toCharArray()) ++hash1[c - 'a'];
        for (char c : target.toCharArray()) ++hash2[c - 'a'];
        int ans = 101;
        for (int i = 0; i < 26; i++) {
            if (hash2[i] > 0) ans = Math.min(ans, hash1[i] / hash2[i]);
        }
        return ans;
    }
}
