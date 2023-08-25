package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII006
 * @since 2023/3/5 21:46
 */
public class OfferII006 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length, l = 0, r = n - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) return new int[]{l, r};
            else if (sum > target) r--;
            else l++;
        }
        return null;
    }

    public int[] twoSum_(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1, t = target - numbers[i];
            while (l <= r) {
                int m = l + r >> 1;
                if (numbers[m] == t) return new int[]{i, m};
                else if (numbers[m] > t) r = m - 1;
                else l = m + 1;
            }
        }
        return null;
    }
}
