package javaguide.basic;

/**
 * 方法的重写要遵循“两同两小一大”（以下内容摘录自《疯狂 Java 讲义》，issue#892open in new window ）：
 * “两同”即方法名相同、形参列表相同；
 * “两小”指的是子类方法返回值类型应比父类方法返回值类型更小或相等，子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等；
 * “一大”指的是子类方法的访问权限应比父类方法的访问权限更大或相等。
 * ------
 * 著作权归所有
 * 原文链接：<a href="https://javaguide.cn/java/basis/java-basic-questions-01.html">JavaGuide</a>
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName OverwriteDemo
 * @since 2023/1/15 20:27
 */
public class P1Overwrite {

    public static void main(String[] args) {
        Integer a = 100, b = 100;
        System.out.println(a == b); // true，数字常量池[-128, 127]

        Integer c = 500, d = 500;
        System.out.println(c == d); // false

        Father son = new Son();

        son.staticMethod();

        son.finalMethod();

        System.out.println(0.99 + 0.01 == 1.); // true
    }

    static class Father {
        Object fun(Object o) throws Exception {
            return new Object();
        }

        // 静态方法不能被重写
        static void staticMethod() {
            System.out.println("static method.");
        }

        // final方法不能被重写
        final void finalMethod() {
            System.out.println("final method.");
        }
    }

    static class Son extends Father {
        @Override
        public Integer fun(Object o) throws RuntimeException {
            return 1;
        }
    }
}
