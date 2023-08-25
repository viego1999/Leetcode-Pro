package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1441 {
    public static void main(String[] args) {

    }

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, j = 0; i < n && j < target.length; i++) {
            ans.add("Push");
            if (i + 1 == target[j]) j++;
            else ans.add("Pop");
        }
        return ans;
    }

    public List<String> buildArray_(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int s = 1;
        for (int num : target) {
            while (num > s++) {
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
        }
        return ans;
    }

    public List<String> buildArrayStack(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int[] stack = new int[n];
        for (int i = 0, j = 0, t = -1; i < n && j < target.length; i++) {
            if (i + 1 == target[j]) {
                while (t != -1 && (j == 0 || stack[t] != target[j - 1])) {
                    --t;
                    ans.add("Pop");
                }
                j++;
            }
            stack[++t] = i + 1;
            ans.add("Push");
        }
        return ans;
    }
}
