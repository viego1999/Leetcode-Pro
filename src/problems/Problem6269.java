package problems;

public class Problem6269 {
    public static void main(String[] args) {

    }

    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length, ans = n;
        for (int i = startIndex; i < n; i++) {
            if (words[i].equals(target)) {
                ans = Math.min(ans, Math.min(i - startIndex, n - (i - startIndex)));
            }
        }
        for (int i = startIndex; i >= 0; i--) {
            if (words[i].equals(target)) {
                ans = Math.min(ans, Math.min(startIndex - i, n - (startIndex - i)));
            }
        }
        return ans == n ? -1 : ans;
    }
}
