package problems;

public class Problem522 {
    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[]{"aabbcc", "aabbcc", "c"}));
    }

    public static int findLUSlength(String[] strs) {
        int ans = -1, n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() <= ans) continue;
            boolean f = true;
            for (int j = 0; j < n; j++) {
                if (i != j && check(strs[i], strs[j])) {
                    f = false;
                    break;
                }
            }
            if (f) ans = Math.max(ans, strs[i].length());
        }
        return ans;
    }

    // 判断str1是否为str2的子序列
    public static boolean check(String str1, String str2) {
        if (str1.length() > str2.length()) return false;
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) i++;
            j++;
        }
        return i == str1.length();
    }
}
