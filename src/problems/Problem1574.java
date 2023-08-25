package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1574
 * @since 2023/3/25 23:11
 */
public class Problem1574 {
    public static void main(String[] args) {

    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, j = n - 1;
        while (j > 0 && arr[j] >= arr[j - 1]) j--;
        if (j == 0) return 0;
        int ans = j;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] < arr[i]) j++;
            ans = Math.min(ans, j - i - 1);
            if (i + 1 < n && arr[i] > arr[i + 1]) break;
        }
        return ans;
    }
}
