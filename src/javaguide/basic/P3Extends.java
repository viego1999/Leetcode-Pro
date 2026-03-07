package javaguide.basic;

/**
 * <pre>
 * 子类拥有父类对象所有的属性和方法（包括私有属性和私有方法），但是父类中的私有属性和方法子类是无法访问，只是拥有。
 * 子类可以拥有自己属性和方法，即子类可以对父类进行扩展。
 * 子类可以用自己的方式实现父类的方法。（以后介绍）。# 多态
 * ------
 * 著作权归所有
 * 原文链接：<a href="https://javaguide.cn/java/basis/java-basic-questions-02.html">JavaGuide</a>
 * </pre>
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName P3Extends
 * @since 2023/2/6 15:05
 */
public class P3Extends {
    public static void main(String[] args) {

    }

    static class Father {
        private String name;
        private int age;
        protected String gender;

        private void privateFather() {
            System.out.println("father private method.");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class Son extends Father {

        void test() {
            System.out.println(this.gender);
        }
    }
}
