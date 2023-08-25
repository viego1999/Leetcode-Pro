package problems;

public class Problem2185 {

    public static void main(String[] args) {

    }

    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.startsWith(pref)) ans++;
        }
        return ans;
    }
}
