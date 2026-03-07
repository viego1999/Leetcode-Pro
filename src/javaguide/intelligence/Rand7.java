package javaguide.intelligence;

/**
 * 给定一个生成1-5的随机函数Rand5()，如何让它生成1-7的随机函数Rand7()
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName Rand7
 * @since 2023/5/29 20:43
 */
public class Rand7 {
    public static void main(String[] args) {
        System.out.println("rand5: " + rand5());
        System.out.println("rand25: " + rand25());
        System.out.println("rand7: " + rand7());
    }

    public static int rand5() {
        return 1 + (int) (Math.random() * 5);
    }

    /**
     * <pre>
     * RandNN= N( RandN()-1 ) + RandN() ;// 生成1到N^2之间的随机数
     * 可以看作是在数轴上撒豆子。N是跨度/步长，是RandN()生成的数的范围长度，
     * RandN()-1的目的是生成0到N-1的数，是跳数。后面+RandN()的目的是填满中间的空隙
     * </pre>
     * @return 返回 [1-25] 的随机数
     */
    public static int rand25() {
        return 5 * (rand5() - 1) + rand5();
    }

    public static int rand7() {
        int x = 30;
        while (x > 21) {
            x = rand25();
        }
        return x % 7 + 1;
    }
}
