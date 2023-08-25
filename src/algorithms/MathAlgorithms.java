package algorithms;

import java.util.*;

public class MathAlgorithms {

    public static void main(String[] args) {
        MathAlgorithms ma = new MathAlgorithms();
        System.out.println(ma.gcd(27, 3));
        System.out.println(ma.gcd2(27, 3));
        System.out.println(ma.lcm(27, 3));
        System.out.println(ma.lcm(3, 24));
        System.out.println(ma.gcd(3, 24));

        System.out.println(ma.decimal2(210.3254));
        System.out.println(ma.decimal3(210.3254));

        System.out.println(ma.checkPowersOfX(656, 5));
        System.out.println(ma.checkPowersOfX(5, 2));

        System.out.println(ma.convertDecimalToOctal(78));
        System.out.println(ma.convertOctalToDecimal(116));

        System.out.println(ma.convertDecimalToDecimal(5678));

        System.out.println(ma.convertDecimalToHex(796));
        System.out.println(ma.convertHexToDecimal("31c"));

        System.out.println(ma.decomposePrimeProduct(30));

        System.out.println(ma.ceil(30, 7));
        System.out.println(ma.ceil(0, 2));

        ma.permutation(new char[]{'a', 'b', 'c'}, 0, 3);

        System.out.println(ma.calculateCombinations(2, 6)); // C2,6
        System.out.println(ma.calculatePermutations(2, 6)); // A2,6

        System.out.println(ma.countStringRearrangements("ABA"));
    }

    public int gcd(int b, int a) { // b >= a

        return a != 0 ? gcd(a, b % a) : b;
    }

    public int gcd2(int b, int a) {
        int c = b % a;
        while (c != 0) {
            b = a;
            a = c;
            c = b % a;
        }
        return a;
    }

    public int lcm(int b, int a) {

        return a * b / gcd(b, a);
    }

    // 四舍五入保留两位小数
    public double decimal2(double d) {
        return (Math.round(d * 100)) / 100.0;
    }

    // 四舍五入保留三位小数（以此类推）
    public double decimal3(double d) {
        return (Math.round(d * 1000)) / 1000.0;
    }

    // 计算 logx(y)=ln(y)/ln(x)
    public double log(int val, int base) {
        return Math.log10(val) / Math.log10(base);
    }

    /**
     * 判断 n 是否是 x 进制数，并计算 x 进制的 01 表达式
     *
     * @param n 十进制数 n
     * @param x x进制
     * @return n 是 x 进制数返回 true，否则返回 false
     */
    public boolean checkPowersOfX(int n, int x) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % x >= 2) return false;
            sb.append(n % x);
            n /= x;
        }
        System.out.println(sb.reverse());
        return true;
    }

    /**
     * 将十进制转换为八进制数
     *
     * @param decimal 十进制数
     * @return 返回转换后的八进制数
     */
    public int convertDecimalToOctal(int decimal) {
        int octal = 0, i = 1;
        while (decimal > 0) {
            octal += (decimal % 8) * i;
            i *= 10;
            decimal /= 8;
        }
        return octal;
    }

    /**
     * 将八进制数转换为10进制 <p>
     * Examples: 116(8) = 1 * 8^2 + 1 * 8^1 + 6 * 8^0 = 78(10)
     *
     * @param octal 八进制数
     * @return 转化后的 10 进制数
     */
    public int convertOctalToDecimal(int octal) {
        int decimal = 0, i = 0;
        while (octal > 0) {
            decimal += (octal % 10) * Math.pow(8, i++);
            octal /= 10;
        }
        return decimal;
    }

    /**
     * 十进制到十进制
     *
     * @param decimal 十进制数
     * @return 返回计算后的十进制数
     */
    public int convertDecimalToDecimal(int decimal) {
        int ret = 0, i = 1;
        while (decimal > 0) {
            ret += (decimal % 10) * i;
            i *= 10;
            decimal /= 10;
        }
        return ret;
    }

    public String convertDecimalToHex(int decimal) {
        StringBuilder sb = new StringBuilder();
        char[] cs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (decimal > 0) {
            sb.append(cs[decimal % 16]);
            decimal /= 16;
        }
        return sb.reverse().toString();
    }

    public int convertHexToDecimal(String hex) {
        int decimal = 0, i = 0;
        char[] cs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < cs.length; j++) map.put(cs[j], j);
        cs = hex.toCharArray();
        for (int j = cs.length - 1; j >= 0; j--) {
            decimal += (int) (map.get(cs[j]) * Math.pow(16, i++));
        }
        return decimal;
    }

    /**
     * 将整数 n 分解成素数乘积
     *
     * @param n - 数 n
     * @return 所有质因数
     */
    public List<Integer> decomposePrimeProduct(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                ans.add(i);
                n /= i;
            }
        }
        return ans;
    }

    /**
     * x / k 向上取整
     *
     * @param x 数 x
     * @param k 数 k
     * @return 返回 x / k 向上取整
     */
    public long ceil(int x, int k) {
        return x == 0 ? 0 : (x - 1) / k + 1;
    }

    /**
     * 全排列输出
     *
     * @param chars 要输出的字符数组
     * @param m     输出字符数组的起始位置
     * @param n     输出字符数组的长度
     */
    public void permutation(char[] chars, int m, int n) {
        if (m < n - 1) {
            // 从第一个数字起每个数分别与它后面的数字交换
            permutation(chars, m + 1, n);
            for (int i = m + 1; i < n; i++) {
                char t = chars[m];
                chars[m] = chars[i];
                chars[i] = t;
                permutation(chars, m + 1, n);
                t = chars[m];
                chars[m] = chars[i];
                chars[i] = t;
            }
        } else {
            // 统计一次排列
            System.out.println(Arrays.toString(chars));
        }
    }

    /**
     * 计算排列数
     * <p>
     * Amn = n!/(n-m)! = n*(n-1)*(n-2)*...*(n-m+1)
     * </p>
     *
     * @param m 数 m
     * @param n 数 n
     * @return 返回 Amn 排列数
     */
    public int calculatePermutations(int m, int n) {
        int ans = 1;
        // n * (n - 1) * ... * (n - m + 1)
        for (int i = n; i > n - m; i--) {
            ans *= i;
        }
        return ans;
    }

    /**
     * 计算组合数
     * <p>
     * Cmn = Amn/m! = n!/(n-m)!*m! = n*(n-1)...(n-m+1)/m!
     * </p>
     *
     * @param m 数 m
     * @param n 数 n
     * @return 返回 Cmn 组合数
     */
    public int calculateCombinations(int m, int n) {
        int ans = 1;
        // Amn
        for (int i = n; i > n - m; i--) {
            ans *= i;
        }
        // Cmn = Amn / m!
        for (int i = m; i > 0; i--) {
            ans /= i;
        }
        return ans;
    }

    /**
     * 计算字符串重新排列数
     *
     * @param s 字符串
     * @return 字符串 s 重新排列数目
     */
    public int countStringRearrangements(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = calculatePermutations(s.length(), s.length());
        for (int i : map.values()) {
            ans /= calculatePermutations(i, i);
        }
        return ans;
    }
}
