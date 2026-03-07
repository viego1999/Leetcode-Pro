package javaguide.anno;

import java.lang.reflect.Method;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName AddMethodExample
 * @since 2023/5/25 22:15
 */
public class AddMethodExample {

    public static void main(String[] args) throws Exception {

        // 获取要添加方法的类的Class对象
        Class<?> myClass = Class.forName("MyClass");

        // 创建一个新的方法
        Method myMethod = MyClass.class.getMethod("myMethod", String.class);

        // 将新的方法添加到类中
        MyMethodAccessor accessor = new MyMethodAccessor();
        accessor.addMethod(myMethod);

        // 通过反射调用新添加的方法
        Object obj = myClass.newInstance();
        Method newMethod = MyClass.class.getMethod("newMethod");
        newMethod.invoke(obj);
    }
}

class MyClass {
    public void myMethod(String msg) {
        System.out.println("MyClass.myMethod() called with message: " + msg);
    }
}

class MyMethodAccessor {
    public void addMethod(Method newMethod) throws Exception {
//        // 获取类的Class对象
//        Class<?> targetClass = MyClass.class;
//
//        // 获取类的Class文件
//        ClassPool pool = ClassPool.getDefault();
//        CtClass cc = pool.get(targetClass.getName());
//
//        // 创建新的方法
//        String methodCode = "public void newMethod() { System.out.println(\"New method added dynamically\"); }";
//        CtMethod newCtMethod = CtNewMethod.make(methodCode, cc);
//
//        // 将新的方法添加到类中
//        cc.addMethod(newCtMethod);
//
//        // 重新加载类
//        Class<?> newClass = cc.toClass(targetClass.getClassLoader(), null);
//
//        // 更新类的Class对象
//        Field field = Class.class.getDeclaredField("classLoader");
//        field.setAccessible(true);
//        field.set(targetClass, newClass.getClassLoader());
    }
}
