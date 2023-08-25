package problems;

public class Problem915 {
    public static void main(String[] args) {

    }

    public int partitionDisjoint(int[] nums) {
        int n = nums.length, l = 0, r = n - 1, t = r, minR = nums[r], maxL = 0;
        for (int i = r; i > l && nums[r] >= nums[0]; --r) { // 找到第一个小于num[0]的数（尽量往右走）
            if (minR > nums[r]) minR = nums[t = r];
        }
        while (l < r) maxL = Math.max(maxL, nums[l++]); // 遍历[0,r）得到左边最大值
        if (maxL > minR) {
            while (l < t) maxL = Math.max(nums[l++], maxL); // 遍历[l,t]得到左边最大值
            while (maxL > nums[l + 1]) maxL = Math.max(maxL, nums[++l]); // 向右走，找到第一个大于等于maxL的数前停下
        }
        return l + 1;
    }

    public int partitionDisjoint_(int[] nums) {
        int n = nums.length, minR = Integer.MAX_VALUE, maxL = 0;
        int[] rightMin = new int[n]; // 记录rightMin[i]表示i位置之后的最小值
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = minR = Math.min(minR, nums[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            maxL = Math.max(maxL, nums[i]); // 找到第一个左边最大值小于等于其右边最小值的数
            if (maxL <= rightMin[i]) return i + 1;
        }
        return 1;
    }
}
