package problems;

import java.util.Arrays;

public class Problem2037 {
    public static void main(String[] args) {

    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0, n = seats.length;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
