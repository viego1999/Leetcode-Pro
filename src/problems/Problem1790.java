package problems;

public class Problem1790 {
    public static void main(String[] args) {

    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int a = -1, b = -1, n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (a == -1) a = i;
                else if (b == -1) {
                    b = i;
                    if (s1.charAt(a) != s2.charAt(b) || s1.charAt(b) != s2.charAt(a)) return false;
                } else return false;
            }
        }
        return b != -1;
    }
}
