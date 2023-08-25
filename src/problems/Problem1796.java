package problems;

public class Problem1796 {
    public static void main(String[] args) {

    }

    public int secondHighest(String s) {
        int first = -1, second = -1;
        for (char c : s.toCharArray()) {
            int a = c - '0';
            if (a >= 0 && a <= 9) {
                if (a > first) {
                    second = first;
                    first = a;
                } else if (a < first && a > second) second = a;
            }
        }
        return second;
    }
}
