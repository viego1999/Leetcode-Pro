package interviews;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName P0502
 * @since 2023/3/2 11:00
 */
public class P0502 {
    public static void main(String[] args) {

    }

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        double x = 0.5;
        while (num > 0) {
            if (num >= x) {
                sb.append('1');
                num -= x;
            } else sb.append('0');
            x /= 2.;
            if (sb.length() >= 34) return "ERROR";
        }
        return sb.toString();
    }
}
