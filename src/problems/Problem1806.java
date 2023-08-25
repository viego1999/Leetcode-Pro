package problems;

public class Problem1806 {

    public static void main(String[] args) {

    }

    public int reinitializePermutation(int n) {
        int[] arr = new int[n], arr1 = new int[n];;
        for (int i = 0; i < n; i++) arr[i] = arr1[i] = i;
        int ans = 0;
        while (++ans > 0) {
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) arr2[i] = arr1[i / 2];
                else arr2[i] = arr1[n / 2 + (i - 1) / 2];
            }
            if (check(arr, arr2)) return ans;
            arr1 = arr2;
        }
        return -1;
    }

    public boolean check(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

}
