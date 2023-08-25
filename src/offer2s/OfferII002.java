package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII002
 * @since 2023/3/4 21:51
 */
public class OfferII002 {
    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int m = a.length(), n = b.length(), i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int t1 = 0, t2 = 0;
            if (i >= 0) t1 = a.charAt(i--) - '0';
            if (j >= 0) t2 = b.charAt(j--) - '0';
            int sum = carry + t1 + t2;
            carry = sum > 1 ? 1 : 0;
            sb.append(sum & 1);
        }
        return sb.reverse().toString();
    }
}
