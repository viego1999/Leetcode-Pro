package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6431
 * @since 2023/5/14 10:34
 */
public class Problem6431 {

    public static void main(String[] args) {

    }

    public boolean doesValidArrayExist(int[] derived) {
        int x = 0;
        for (int d : derived) x ^= d;
        return x == 0;
    }
}
