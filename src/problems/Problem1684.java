package problems;

public class Problem1684 {
    public static void main(String[] args) {

    }

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] hash = new boolean[26];
        int ans = words.length;
        for (char c : allowed.toCharArray()) hash[c - 'a'] = true;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!hash[c - 'a']) {
                    --ans;
                    break;
                }
            }
        }
        return ans;
    }
}
