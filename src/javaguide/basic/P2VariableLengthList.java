package javaguide.basic;

import java.math.BigDecimal;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName P2VariableLengthList
 * @since 2023/2/6 11:45
 */
public class P2VariableLengthList {
    public static void main(String[] args) {
        lengthList("a", "b", "c");
        lengthList(new String[]{"a", "b", "c"});

        Integer i1 = 10; // 等价于
        Integer i2 = Integer.valueOf(10);

        int n1 = i1; // 等价于
        int n2 = i2.intValue();

        BigDecimal f1 = new BigDecimal("0.66");
        BigDecimal f2 = new BigDecimal("0.34");
        System.out.println(f1.subtract(f2).floatValue() == 0.32f); // true

        float ff1 = 0.66f, ff2 = 0.34f;
        System.out.println(ff1 - ff2 == 0.32f); // false
    }

    public static void lengthList(String... strs) {
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
