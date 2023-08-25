package problems;

public class Problem1764 {
    public static void main(String[] args) {

    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0, j = 0, m = groups.length, n = nums.length;
        while (i < m && j < n) {
            if (check(groups[i], nums, 0, j)) j += groups[i++].length;
            else j++;
        }
        return i == m;
    }

    public boolean check(int[] a, int[] b, int i, int j) {
        if (a.length > b.length - j) return false;
        while (i < a.length && j < b.length) {
            if (a[i++] != b[j++]) return false;
        }
        return true;
    }
}
