package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem831
 * @since 2023/4/1 15:38
 */
public class Problem831 {
    public static void main(String[] args) {

    }

    public String maskPII(String s) {
        int idx = s.indexOf('@'), len;
        StringBuilder sb = new StringBuilder();
        if (idx != -1) {
            s = s.toLowerCase();
            sb.append(s.charAt(0)).append("*****").append(s.charAt(idx - 1)).append(s.substring(idx));
        } else {
            StringBuilder numbers = new StringBuilder();
            for (char c : s.toCharArray()) if (Character.isDigit(c)) numbers.append(c);
            len = numbers.length();
            sb.append(len == 10 ? "" : len == 11 ? "+*-" : len == 12 ? "+**-" : "+***-")
                    .append("***-***-").append(numbers.substring(len - 4));
        }
        return sb.toString();
    }
}
