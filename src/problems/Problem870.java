package problems;

import java.util.Arrays;

public class Problem870 {
    public static void main(String[] args) {

    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idxs = new Integer[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) idxs[i] = i;
        Arrays.sort(nums1);
        Arrays.sort(idxs, (x, y) -> nums2[x] - nums2[y]);
        for (int i = 0, l = 0, r = n; i < n; i++) {
            if (nums1[i] > nums2[idxs[l]]) ans[idxs[l++]] = nums1[i];
            else ans[idxs[--r]] = nums1[i];
        }
        return ans;
    }

    public int[] advantageCount1(int[] nums1, int[] nums2) {
        int i = 0, n = nums1.length, l = 0, r = n;
        int[][] temp = new int[n][2];
        int[] ans = new int[n];
        for (int t = 0; t < n; t++) {
            temp[t][0] = nums2[t];
            temp[t][1] = t;
        }
        Arrays.sort(nums1);
        Arrays.sort(temp, (x, y) -> x[0] - y[0]);
        while (i < n) {
            while (i < n && l < n && nums1[i] <= temp[l][0]) ans[temp[--r][1]] = nums1[i++];
            if (i < n) ans[temp[l++][1]] = nums1[i++];
        }
//        for (int t = 0; t < n; t++) nums1[temp[t][1]] = temp[t][0];
        return ans;
    }
}
