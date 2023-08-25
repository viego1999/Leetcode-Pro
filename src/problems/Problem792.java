package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem792 {
    public static void main(String[] args) {

    }

    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] hash = new ArrayList[26];
        for (int i = 0; i < 26; i++) hash[i] = new ArrayList<>();
        char[] cs = s.toCharArray();
        int n = cs.length, ans = 0;
        for (int i = 0; i < n; i++) hash[cs[i] - 'a'].add(i);
        Integer[][] arr = new Integer[26][];
        for (int i = 0; i < 26; i++) arr[i] = hash[i].toArray(new Integer[0]);
        System.out.println(words.length);
        for (String word : words) {
            char[] cc = word.toCharArray();
            int last = -1, cnt = 1; // 上一个字符在s中的下标
            int[] indices = new int[26]; // 每个字符的索引数组的起始位置
            for (char c : cc) {
                int i = c - 'a', idx = binarySearch(arr[i], indices[i], last);
                if (idx == -1) {
                    cnt = 0;
                    break;
                }
                indices[i] = idx + 1;
                last = hash[i].get(idx);
            }
            ans += cnt;
        }
        return ans;
    }

    public int binarySearch(Integer[] list, int left, int k) {
        int l = left, r = list.length - 1;
        if (l > r || list[r] <= k) return -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list[mid] <= k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
