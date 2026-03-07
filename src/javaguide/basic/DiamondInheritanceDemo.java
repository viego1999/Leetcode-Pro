package javaguide.basic;

/**
 * 菱形继承 Demo
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName DiamondInheritanceDemo
 * @since 2023/3/21 22:40
 */
public class DiamondInheritanceDemo {
    public static void main(String[] args) {
        GrandFather son1 = new Son1();
        son1.say();

        GrandFather son2 = new Son2();
        son2.say();

        GrandFather son3 = new Son3();
        son3.say();
    }

    interface GrandFather {
        default void say() {
            System.out.println("GrandFather say.");
        }
    }

    interface Father1 extends GrandFather {
        @Override
        default void say() {
            System.out.println("Father1 say.");
        }
    }

    interface Father2 extends GrandFather {
        @Override
        default void say() {
            System.out.println("Father2 say.");
        }
    }

    static class Son1 implements Father1, Father2 {
        @Override
        public void say() {
            System.out.println("Son say");
        }
    }

    static class Son2 implements Father2 {

    }

    static class Son3 implements Father1, Father2 {

        @Override
        public void say() {
            Father1.super.say();
        }
    }
}
