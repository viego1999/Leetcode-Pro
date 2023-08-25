package problems;

import java.util.Arrays;

public class Problem1636 {
    public static void main(String[] args) {

    }

    public int[] frequencySort(int[] nums) {
        int[][] cnt = new int[201][2];
        for (int num : nums) {
            ++cnt[100 + num][0];
            cnt[100 + num][1] = num;
        }
        Arrays.sort(cnt, (x, y) -> x[0] != y[0] ? x[0] - y[0] : y[1] - x[1]);
        for (int i = 0, t = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i][0]; j++) {
                nums[t++] = cnt[i][1];
            }
        }
        return nums;
    }
}
