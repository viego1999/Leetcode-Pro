package problems;

public class Problem1822 {
    public static void main(String[] args) {

    }

    public int arraySign(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) cnt++;
        }
        return (cnt & 1) == 0 ? 1 : -1;
    }
}
