package problems;

import java.util.Arrays;

public class Problem1619 {
    public static void main(String[] args) {

    }

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, sum = 0;
        for (int i = (int) (n * 0.05); i < n * 0.95; i++) {
            sum += arr[i];
        }
        return sum / (n * 0.9);
    }
}
