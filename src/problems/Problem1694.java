package problems;

public class Problem1694 {
    public static void main(String[] args) {

    }

    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        char[] cs = number.replace("-", "").replace(" ", "").toCharArray();
        int n = cs.length, i = 0;
        while (i + 3 <= n) {
            if (n - i == 4) return sb.append(new String(cs, i, 2)).append("-").append(cs, i + 2, 2).toString();
            else sb.append(new String(cs, i, 3));
            if ((i += 3) != n) sb.append("-");
        }
        if (i < n) sb.append(new String(cs, i, n - i));
        return sb.toString();
    }
}
