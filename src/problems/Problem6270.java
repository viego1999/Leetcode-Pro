package problems;

public class Problem6270 {
    public static void main(String[] args) {

    }

    /*
        问题转化为从中间去掉一段连续的序列，使得剩下的元素中abc均大于等于k
        也就是中间的区间中abc的数目小于其总数减去k
     */
    public int takeCharacters(String s, int k) {
        char[] cs = s.toCharArray();
        int[] cnts = new int[3], nums = new int[3];
        for (char c : cs) cnts[c - 'a']++;
        if (cnts[0] < k || cnts[1] < k || cnts[2] < k) return -1;
        for (int i = 0; i < cnts.length; i++) cnts[i] -= k;
        int ans = Integer.MAX_VALUE, n = s.length(), l = 0, r = 0;
        while (r < n) {
            nums[cs[r] - 'a']++;
            while (nums[cs[r] - 'a'] > cnts[cs[r] - 'a']) {
                nums[cs[l++] - 'a']--;
            }
            ans = Math.min(n - (r - l + 1), ans);
            r++;
        }
        return ans;
    }
}
