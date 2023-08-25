package problems;

public class Problem6246 {
    public static void main(String[] args) {

    }

    public int appendCharacters(String s, String t) {
        char[] ss = s.toCharArray(), ts = t.toCharArray();
        int m = s.length(), n = t.length(), i = 0, j = 0;
        while (i < m && j < n) {
            if (ss[i] == ts[j]) j++;
            i++;
        }
        return n - j;
    }
}
