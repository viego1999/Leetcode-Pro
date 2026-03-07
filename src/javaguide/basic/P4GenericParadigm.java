package javaguide.basic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * public static < E > void printArray( E[] inputArray ) 一般被称为静态泛型方法;在 java 中泛型只是一个占位符，
 * 必须在传递类型后才能使用。类在实例化时才能真正的传递类型参数，由于静态方法的加载先于类的实例化，也就是说类中的泛型还没有
 * 传递真正的类型参数，静态的方法的加载就已经完成了，所以静态泛型方法是没有办法使用类上声明的泛型的。只能使用自己声明的 <E>
 * ------
 * 著作权归所有
 * 原文链接：<a href="https://javaguide.cn/java/basis/java-basic-questions-03.html">...</a>
 * <p>
 * 类型擦除
 * </p>
 * <pre>
 * {@code
 *     // 泛型擦除指的在编译期间，将 <T> 擦除，然后将 T 替换为 Object 或指定的 Xxx 类型，
 *     <T> T test(T a, T b);  =               ====>     Object test(Object a, Object b);
 *
 *     <T extends Number> T comp(T a, T b);   ====>     Number comp(Number a, Number b);
 *
 *     class Pair<T> {                        ====>     class Pair {
 *         T elem;                                          Object elem;
 *         // ...                                           // ...
 *     }                                                }
 *
 *     List<String> ss = new ArrayList<>();   ====>     List ss = new ArrayList();
 * }
 * </pre>
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName P4GenericParadigm
 * @since 2023/2/6 17:12
 */
public class P4GenericParadigm {
    public static void main(String[] args) throws Exception {
        // 类型擦除
        List<Integer> list = new ArrayList<>();
        list.add(12);

        // 1.编译期间直接添加会报错
        // list.add("a");

        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        // 2.运行期间通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);

        List<?> list1 = new ArrayList<>();
//        list1.add("sss");//报错
        List list2 = new ArrayList<>();
        list2.add("sss");//警告信息

        Class<?> clz = null;
        clz = P4GenericParadigm.class;

        List<Animal> animals = Arrays.asList(new Mouse(), new Lion());
        List<? extends Animal> animals1 = new ArrayList<>(animals);

        // 上边界通配符指明了父类型，不确定子类型，因此只能从父类取数据，不能存数据
        // 只能保证取到的数据都为 Animal 的子类，当进行添加时，因为是?参数，不确定添加的元素是否为Number的子类
        Animal animal = animals1.get(0);
        // numbers.set(0, new Mouse());     // 报错 Required type:capture of ? extends Animal     Provided:Mouse
        // numbers.add(new Lion());         // 报错 Required type:capture of ? extends Animal     Provided:Lion
        for (Animal animal1 : animals) {
//            System.out.println(animal1);
        }

        // 下边界通配符指明了子类型，不确定父类型，因此只能子类存数据，不能子类取数据。
        // 只能保证存储的数据一定为 Animal 类，不能保证取出来的元素为 Animal，取出来的元素只能为 Animal 的父类
        List<? super Animal> animals2 = new ArrayList<>(animals);
        animals2.add(new Tiger());
        animals2.add(new Animal());
        Object number1 = animals2.get(0);
        for (Object o : animals2) {
//            System.out.println(o);
        }

        Tiger tiger = new Tiger();
        Animal anim = new Animal();
        Animal a2 = tiger;
//        Tiger t2 = (Tiger) anim; // 报错
    }

    static class Generic<T> {
        T elem;

        void method(T[] elems) {

        }

        // 注意：静态方法只能使用自己定义的 T 泛型
        static <T> void staticMethod(T[] elems) {

        }
    }

    static class AbstractAnimal {

    }

    static class Animal extends AbstractAnimal {

    }

    static class Tiger extends Animal {

    }

    static class Mouse extends Animal {

    }

    static class Lion extends Animal {

    }
}
