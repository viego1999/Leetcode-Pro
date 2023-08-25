package interviews;

public class P0901 {
    public static void main(String[] args) {

    }

    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

    public boolean isFlipedString_(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return true;
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        for (int i = 0, n = s1.length(); i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n && flag; j++) {
                if (cs1[(i + j) % n] != cs2[j]) flag = false;
            }
            if (flag) return true;
        }
        return false;
    }
}
