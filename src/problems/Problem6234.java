package problems;

public class Problem6234 {
    public static void main(String[] args) {

    }

    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = i; j < n; j++) {
                x = lcm(x, nums[j]);
                if (x == k) ans++;
                else if (x > k) break;
            }
        }
        return ans;
    }

    public int gcd(int b, int a) {
        return a != 0 ? gcd(a, b % a) : b;
    }

    public int lcm(int b, int a) {
        return a * b / gcd(b, a);
    }
}
