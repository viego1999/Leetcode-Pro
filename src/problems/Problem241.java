package problems;

import java.util.*;

/**
 * 241. 为运算表达式设计优先级
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 *
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2：
 *
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 *
 * 提示：
 *
 * 1 <= expression.length <= 20
 * expression 由数字和算符 '+'、'-' 和 '*' 组成。
 * 输入表达式中的所有整数值在范围 [0, 99]
 *
 * link: https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */
public class Problem241 {

    public static void main(String[] args) {
        System.out.println(diffWaysToComputeDp("2*3-4*5"));
    }

    public static List<Integer> diffWaysToComputeDp(String expression) {
        char[] chars = expression.toCharArray();
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int num = 0, n;
        for (char c : chars) {
            if (isOperator(c)) {
                ops.add(c);
                nums.add(num);
                num = 0;
            } else num = num * 10 + (c - '0');
        }
        nums.add(num);
        List<Integer>[][] dp = new ArrayList[(n = nums.size())][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new ArrayList<>();
                if (i == j) dp[i][j].add(nums.get(i));
            }
        }
        for (int i = n - 1; i >= 0; i--) { // dp[i][j] = dp[i][s] op dp[s + 1][j];
            for (int j = i; j < n; j++) {
                for (int s = 0; s < j; s++) {
                    for (int l : dp[i][s]) {
                        for (int r : dp[s + 1][j]) {
                            dp[i][j].add(calculate(l, r, ops.get(s)));
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) return memo.get(expression);
        List<Integer> ans = new ArrayList<>();
        char[] chars = expression.toCharArray();
        int num = 0, idx = 0, n = expression.length();
        while (idx < n && !isOperator(chars[idx])) num = num * 10 + (chars[idx++] - '0');
        if (idx == n) return Collections.singletonList(num);
        for (int i = 1; i < n; i++) {
            if (isOperator(chars[i])) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, n));
                for (int l : left) {
                    for (int r : right) {
                        ans.add(calculate(l, r, chars[i]));
                    }
                }
            }
        }
        memo.put(expression, ans);
        return ans;
    }

    public static boolean isOperator(char s) {
        return s == '+' || s == '-' || s == '*';
    }

    public static int calculate(int a, int b, char c) {
        if (c == '+') return a + b;
        else if (c == '-') return a - b;
        else return a * b;
    }
}
