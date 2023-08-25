package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem2032 {
    public static void main(String[] args) {

    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        int[] hash = new int[101];
        for (int num : nums1) if (hash[num] == 0) hash[num] += 1;
        for (int num : nums2) {
            if (hash[num] == 0) hash[num] = 2;
            else if (hash[num] == 1) {
                hash[num] += 2;
                ans.add(num);
            }
        }
        for (int num : nums3) {
            if (hash[num] == 1 || hash[num] == 2) {
                ans.add(num);
                hash[num] += 3;
            }
        }
        return ans;
    }
}
