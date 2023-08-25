package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII076
 * @since 2023/5/15 22:49
 */
public class OfferII076 {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    public int quickSelect(int[] nums, int l, int r, int k) {
        int pivot = nums[l], i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] > pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[l] = nums[j];
        nums[j] = pivot;
        int cnt = j - l + 1;
        if (cnt < k) return quickSelect(nums, j + 1, r, k - cnt);
        else if (cnt == k) return nums[j];
        else return quickSelect(nums, l, j - 1, k);
    }
}
