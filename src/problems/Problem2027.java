package problems;

public class Problem2027 {
    public static void main(String[] args) {

    }

    public int minimumMoves(String s) {
        int n = s.length(), ans = 0, i = 0;
        while (i < n) {
            if (s.charAt(i) == 'X') {
                i += 3;
                ans++;
            } else i++;
        }
        return ans;
    }
}
