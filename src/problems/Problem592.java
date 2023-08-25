package problems;

/**
 * 592. 分数加减运算
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。
 * <p>
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 * 示例 2:
 * <p>
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 * <p>
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 * <p>
 * link: https://leetcode.cn/problems/fraction-addition-and-subtraction/
 */
public class Problem592 {
    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2"));
        System.out.println(fractionAddition("-1/2+1/2+1/3"));
        System.out.println(fractionAddition("1/3-1/2"));
        System.out.println(fractionAddition("5/3+1/3"));
        System.out.println(fractionAddition("7/2+2/3-3/4"));
    }

    // -1/3+1/2=1/6
    public static String fractionAddition(String expression) {
        int a = 0, b = 1, c = 0, d = 0, div = 0, n = expression.length(), sign = 1;
        char[] cs = expression.toCharArray();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(cs[i])) {
                if (div == 0) c = c * 10 + (cs[i] - '0');
                else d = d * 10 + (cs[i] - '0');
            } else if (cs[i] == '/') div = 1;
            if (cs[i] == '-' || cs[i] == '+' || i == n - 1) { // 进行运算
                if (div == 1) {// 计算
                    a = (a * d + sign * c * b);
                    b *= d;
                    c = d = div = 0;
                }
                sign = cs[i] == '-' ? -1 : 1;
            }
        }
        int g = gcd(Math.abs(a), b);
        return Integer.toString(a / g) + '/' + Integer.toString(b / g);
    }

    public static String fractionAddition2(String expression) {
        int a = 0, b = 1, i = 0, n = expression.length();
        char[] cs = expression.toCharArray();
        while (i < n) {
            int c = 0, d = 0, sign = 1;
            if (cs[i] == '-' || cs[i] == '+') sign = cs[i++] == '-' ? -1 : 1;
            while (i < n && Character.isDigit(cs[i])) c = c * 10 + (cs[i++] - '0');
            i++;
            while (i < n && Character.isDigit(cs[i])) d = d * 10 + (cs[i++] - '0');
            a = (a * d + sign * c * b);
            b *= d;
        }
        int g = gcd(Math.abs(a), b);
        return Integer.toString(a / g) + '/' + Integer.toString(b / g);
    }

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
