package javaguide.basic;

/**
 * Java 中将实参传递给方法（或函数）的方式是 值传递 ：如果参数是基本类型的话，很简单，传递的就是基本类型的字面量值的拷贝，会创建副本。
 * 如果参数是引用类型，传递的就是实参所引用的对象在堆中地址值的拷贝，同样也会创建副本。
 * ------
 * 著作权归所有
 * 原文链接：<a href="https://javaguide.cn/java/basis/why-there-only-value-passing-in-java.html">JavaGuide</a>
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName P5PassByValue
 * @since 2023/2/6 20:29
 */
public class P5PassByValue {
    public static void main(String[] args) {
        Person xiaoMing = new Person("XiaoMing");
        Person xiaoLiu = new Person("XiaoLiu");
        testModifyContent(xiaoMing, xiaoLiu);
        System.out.println(xiaoMing);
        System.out.println(xiaoLiu);

        testModifyObject(xiaoMing, xiaoLiu);
        System.out.println(xiaoMing);
        System.out.println(xiaoLiu);
    }

    public static void testModifyContent(String str1) {

    }

    // person1这个形参指向的是实参指向对象的地址的拷贝，会创建副本，person2也如此
    // 因此改变 p1 或 p2 形参的指向不会影响到原对象，但是可以通过形参来改变对应地址对象的内容
    public static void testModifyContent(Person person1, Person person2) {
        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);

        System.out.println("============ 修改内容 =============");

        // 改变 形参所指向的对象的内容
        person1.setName("XiaoMing2");
        person2.setName("XiaoLiu2");
    }

    public static void testModifyObject(Person person1, Person person2) {
        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);

        System.out.println("============ 修改指向 =============");

        person1 = new Person("new" + person1.getName());
        person2 = new Person("new" + person2.getName());
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
