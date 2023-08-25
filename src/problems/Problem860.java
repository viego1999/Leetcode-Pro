package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem860
 * @since 2023/7/24 0:36
 */
public class Problem860 {
    public static void main(String[] args) {

    }

    public boolean lemonadeChange(int[] bills) {
        int[] cnts = new int[3];
        for (int bill : bills) {
            int idx = bill == 5 ? 0 : bill == 10 ? 1 : 2;
            if (idx > 0) {
                if (idx == 1) {
                    if (--cnts[0] < 0) return false;
                    cnts[1]++;
                } else {
                    if (cnts[1] == 0) {
                        if (cnts[0] < 3) return false;
                        cnts[0] -= 3;
                    } else {
                        if (cnts[0] < 1) return false;
                        cnts[1]--;
                        cnts[0]--;
                    }
                }
            } else cnts[0]++;
        }
        return true;
    }
}
