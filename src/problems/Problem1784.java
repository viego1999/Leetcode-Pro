package problems;

public class Problem1784 {
    public static void main(String[] args) {

    }

    public boolean checkOnesSegment(String s) {
        int cnt = 0, i = 0, n = s.length();
        char[] cs = s.toCharArray();
        while (i < n) {
            if (cs[i] == '1') {
                while (i < n && cs[i] == '1') i++;
                if (++cnt > 1) return false;
            } else i++;
        }
        return true;
    }
}
