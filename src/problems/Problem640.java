package problems;

/**
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 如果方程中只有一个解，要保证返回值 'x' 是一个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 *
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 *
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 *
 *
 *
 *
 * 提示:
 *
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。
 *
 * link: https://leetcode.cn/problems/solve-the-equation/
 */
public class Problem640 {
    public static void main(String[] args) {
        System.out.println(solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solveEquation("x=x"));
        System.out.println(solveEquation("2x=x"));
        System.out.println(solveEquation("x=x+1"));
        System.out.println(solveEquation("0-x=1"));
        System.out.println(solveEquation("-1x=1"));
        System.out.println(solveEquation("-x=-1"));
        System.out.println(solveEquation("0x=0"));
        System.out.println(solveEquation("1+1=x"));
    }

    // x+5-3+x=6+x-2
    // 2x+5=0
    public static String solveEquation(String equation) {
        int cnt = 0, sum = 0, num = 0, sign = 1, flag = 1, n = equation.length(); // x的系数，数字之和，当前数字，符号，左右标志
        char[] cs = equation.toCharArray();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(cs[i])) num = num * 10 + (cs[i] - '0');
            else {
                if (cs[i] == 'x') cnt += num != 0 || (i > 0 && cs[i - 1] == '0') ? sign * num * flag : sign * flag;
                else if (cs[i] == '=') {
                    sum += sign * num * flag;
                    flag = -(sign = 1);
                } else if (cs[i] == '+' || cs[i] == '-') {
                    sum += sign * num * flag;
                    sign = cs[i] == '+' ? 1 : -1;
                }
                num = 0;
            }
            if (i == n - 1) sum += num * flag * sign;
        }
        return cnt == 0 && cnt == sum ? "Infinite solutions" : cnt == 0 ? "No solution" : "x=" + String.valueOf(sum / -cnt);
    }
}
