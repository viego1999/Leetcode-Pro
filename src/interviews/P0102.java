package interviews;

public class P0102 {
    public static void main(String[] args) {

    }

    public boolean CheckPermutation(String s1, String s2) {
        int[] hash = new int[26];
        for (char c : s1.toCharArray()) hash[c - 'a']++;
        for (char c : s2.toCharArray()) if (--hash[c - 'a'] < 0) return false;
        return true;
    }
}
