package problems;

import java.util.Arrays;

public class Problem28_ {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (n < m) return -1;
        int[] shiftTable = new int[26];
        Arrays.fill(shiftTable, m + 1);
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        for (int i = 0; i < m; i++) {
            shiftTable[needles[i] - 'a'] = m - i;
        }
        int i = 0;
        while (i + m <= n) {
            int k = 0;
            while (k < m && haystacks[i + k] == needles[k]) k++;
            if (k == m) return i;
            if (i + m < n) i += shiftTable[haystacks[i + m] - 'a'];
            else return -1;
        }
        return -1;
    }
}
