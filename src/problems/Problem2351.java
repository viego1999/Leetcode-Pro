package problems;

public class Problem2351 {

    public static void main(String[] args) {

    }

    public char repeatedCharacter(String s) {
        int state = 0;
        for (char c : s.toCharArray()) {
            int t = c - 'a';
            if (((state >> t) & 1) == 1) return c;
            else state |= (1 << t);
        }
        return 'a';
    }
}
