package problems;

public class Problem6289 {

    public static void main(String[] args) {

    }

    public int xorBeauty(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
