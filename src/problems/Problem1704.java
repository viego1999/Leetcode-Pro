package problems;

public class Problem1704 {
    public static void main(String[] args) {

    }

    public boolean halvesAreAlike(String s) {
        String pattern = "aeiouAEIOU";
        int a = 0, b = 0;
        for (int i = 0, n = s.length(); i < n / 2; i++) {
            if (pattern.indexOf(s.charAt(i)) != -1) a++;
            if (pattern.indexOf(s.charAt(n - 1 - i)) != -1) b++;
        }
        return a == b;
    }
}
