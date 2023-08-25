package problems;

public class Problem1750 {

    public static void main(String[] args) {

    }

    public int minimumLength(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1, i = 0;
        while (l < r && cs[i = l] == cs[r]) {
            while (l <= r && cs[l] == cs[i]) l++;
            while (r >= l && cs[r] == cs[i]) r--;
        }
        return r - l + 1;
    }
}
