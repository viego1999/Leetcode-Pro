package javaguide.basic;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <?> 无限制通配符
 * <? extends E> extends 关键字声明了类型的上界，表示参数化的类型可能是所指定的类型，或者是此类型的子类
 * <? super E> super 关键字声明了类型的下界，表示参数化的类型可能是指定的类型，或者是此类型的父类
 *
 * // 使用原则《Effictive Java》
 * // 为了获得最大限度的灵活性，要在表示 生产者或者消费者 的输入参数上使用通配符，使用的规则就是：生产者有上限、消费者有下限
 * 1. 如果参数化类型表示一个 T 的生产者，使用 < ? extends T>;
 * 2. 如果它表示一个 T 的消费者，就使用 < ? super T>；
 * 3. 如果既是生产又是消费，那使用通配符就没什么意义了，因为你需要的是精确的参数类型。
 * ------
 * 著作权归@pdai所有
 * 原文链接：https://pdai.tech/md/java/basic/java-basic-x-generic.html
 */
public class GenericParadigm {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int a = 1;
        float b = 2.00f;
        System.out.println(add(a, b));
        System.out.println(GenericParadigm.<Number>add(4, 5));
        System.out.println(getObject(Class.forName("javaguide.basic.GenericParadigm")));
        System.out.println(Class.forName("javaguide.basic.GenericParadigm"));

        // Java 中是不能创建一个确切的泛型类型的数组的，除非是采用通配符的方式且要做显式类型转换才可以
        List<String>[] lists = new ArrayList[10];
        List<String>[] lists1 = (List<String>[]) new ArrayList<?>[10];
        List<String>[] lists2 = (List<String>[]) new ArrayList[10];

        List<?> list = new ArrayList<>();
        List<?>[] lists3 = new ArrayList[10];
        List<?>[] lists4 = new ArrayList<?>[10];

        // 引发编译错误：Required type:capture of ? Provided: String
        // 因为程序无法确认集合中的元素类型，所以不能向其中添加元素。
        // list.add("hello");
        // lists3[0] = new ArrayList<>();
        // lists3[0].add("hello");

        // 发生 java.lang.ArrayStoreException
//        lists3[0] = Arrays.asList(1, 2, 3);

        lists3[0] = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(lists3[0]);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.getClass().getMethod("add", Object.class).invoke(list1, "asd");
        System.out.println(list1);

        System.out.println(ArrayWithTypeToken.get("5").getClass());
    }

    private static <T extends Number> double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T> T getObject(Class<T> c) {
        T t;
        try {
            t = c.newInstance();
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    static class A {
    }

    static class B extends A {
    }

    // 解决泛型中隐含的转换问题，Java泛型加入了类型参数的上下边界机制
    // <? extends A>表示该类型参数可以是A(上边界)或者A的子类类型。编译时擦除到类型A，即用A类型代替类型参数。
    public static void funA(List<? extends A> listA) {

    }

    public static void funB(List<B> listB) {
        funA(listB);
    }

    // <? super E> super 关键字声明了类型的下界，表示参数化的类型可能是指定的类型，或者是此类型的父类
    public static void funC(List<? super B> listC) {
        funA((List<? extends A>) listC);
    }

    static class ArrayWithTypeToken<T> {
        private final T[] array;

        public ArrayWithTypeToken(Class<T> type, int size) {
            array = (T[]) Array.newInstance(type, size);
        }

        public void put(int index, T item) {
            array[index] = item;
        }

        public static <T> T get(T index) {
//            return array[index];
            return index;
        }

        public T[] create() {
            return array;
        }
    }
}
