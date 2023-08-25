package problems;

public class Problem769 {
    public static void main(String[] args) {

    }

    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }

    public int maxChunksToSorted_(int[] arr) {
        int ans = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int max = arr[i];
            while (i < max) max = Math.max(max, arr[++i]);
            ans++;
        }
        return ans;
    }
}
