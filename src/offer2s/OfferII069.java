package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII069
 * @since 2023/5/15 20:28
 */
public class OfferII069 {
    public static void main(String[] args) {

    }

    public int peakIndexInMountainArray_(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        while (l < r) {
            int m1 = l + (r - l) / 3, m2 = r - (r - l) / 3;
            if (arr[m1] > arr[m2]) r = m2 - 1;
            else l = m1 + 1;
        }
        return l;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (arr[m - 1] < arr[m]) l = m;
            else r = m - 1;
        }
        return l;
    }
}
