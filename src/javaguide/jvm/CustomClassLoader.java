package javaguide.jvm;

/**
 * <p>
 * 自定义加载器的话，需要继承 ClassLoader 。如果我们不想打破双亲委派模型，就重写 ClassLoader 类中的 findClass() 方法即可，无法被父类加载器
 * 加载的类最终会通过这个方法被加载。但是，如果想打破双亲委派模型则需要重写 loadClass() 方法
 * </p>
 * <p>
 * ------
 * 著作权归所有
 * 原文链接：<a href="https://javaguide.cn/java/jvm/classloader.html">JavaGuide</a>
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName CustomClassLoader
 * @since 2023/2/12 17:45
 */
public class CustomClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cl1 = Class.forName("java.lang.String");
        Class<?> cl2 = ClassLoader.getSystemClassLoader().loadClass("java.lang.String");
        System.out.println(cl1 == cl2); // true
    }

    // 重写 loadClass 方法则会打破双亲委派机制
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

    // 重写 findClass 方法，不打破双亲委派机制
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
