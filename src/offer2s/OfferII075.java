package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII075
 * @since 2023/5/15 22:43
 */
public class OfferII075 {
    public static void main(String[] args) {

    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] hash = new int[1005];
        for (int a : arr1) hash[a]++;
        int t = 0;
        for (int a : arr2) {
            while (hash[a]-- > 0) arr1[t++] = a;
        }
        for (int i = 0; i < hash.length; i++) {
            for (int j = 0; j < hash[i]; j++) arr1[t++] = i;
        }
        return arr1;
    }
}
