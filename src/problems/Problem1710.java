package problems;

import java.util.Arrays;

public class Problem1710 {
    public static void main(String[] args) {

    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);
        int ans = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                truckSize -= box[0];
                ans += box[0] * box[1];
            } else return ans + box[1] * truckSize;
        }
        return ans;
    }
}
