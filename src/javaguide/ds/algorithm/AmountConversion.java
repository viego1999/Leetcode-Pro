package javaguide.ds.algorithm;

import java.util.Scanner;

/**
 * 华为24暑期实习一面算法题
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName ds.algorithm.AmountConversion
 * @since 2023/5/27 9:23
 */
public class AmountConversion {
    /**
     * 金额转换，阿拉伯数字的金额转换成中国传统的形式如：（￥1011）－>（一千零一拾一元整）输出
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int k = 1;
        while (str.charAt(k) == '0') k++;
        char[] cs = str.substring(k).toCharArray();
        int len = cs.length;
        StringBuilder sb = new StringBuilder();
        String[] strs = {"", "拾", "百", "千"};
        String[] numbers = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        boolean flag = false;
        for (int i = len - 1, j = 0; i >= 0; i--, j++) {
            int t = cs[i] - '0';
            if (t > 0) flag = true;
            if (!flag) continue;
            if (i < len - 1 && cs[i + 1] - '0' == 0 && t == 0) continue;
            sb.insert(0, numbers[t] + (t > 0 ? strs[j] : ""));
        }
        sb.append("元整");
        System.out.println(sb);
    }
}
