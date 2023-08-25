package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1138
 * @since 2023/2/12 10:01
 */
public class Problem1138 {
    public static void main(String[] args) {

    }

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        char[] cs = target.toCharArray();
        for (int i = 0, j = 0; i < cs.length; i++) {
            int x1 = j / 5, y1 = j % 5;
            j = cs[i] - 'a';
            int x2 = j / 5, y2 = j % 5;
            for (; x2 < x1; x2++) sb.append('U');
            for (; y2 < y1; y2++) sb.append('L');
            for (; x1 < x2; x1++) sb.append('D');
            for (; y1 < y2; y1++) sb.append('R');
            sb.append('!');
        }
        return sb.toString();
    }
}
