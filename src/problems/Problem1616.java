package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1616
 * @since 2023/3/18 15:11
 */
public class Problem1616 {
    public static void main(String[] args) {

    }

    public boolean checkPalindromeFormation(String a, String b) {
        return helper(a, b) || helper(b, a);
    }

    public boolean helper(String a, String b) {
        int n = a.length(), i = 0, j = n - 1;
        while (i < n && j >= 0 && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }
        if (i == n && j == -1) return true;
        StringBuilder sb = new StringBuilder();
        sb.append(a, 0, j + 1).append(b.substring(j + 1));
        if (sb.toString().equals(sb.reverse().toString())) return true;
        sb = new StringBuilder();
        sb.append(a, 0, i).append(b.substring(i));
        return sb.toString().equals(sb.reverse().toString());
    }
}
