package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1053
 * @since 2023/4/3 13:12
 */
public class Problem1053 {
    public static void main(String[] args) {

    }

    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length, i = n - 1, j = n - 1;
        while (i > 0 && arr[i] >= arr[i - 1]) i--;
        if (i-- > 0) {
            while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) j--;
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
}
