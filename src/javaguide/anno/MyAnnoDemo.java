package javaguide.anno;

import java.lang.reflect.Method;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName MyAnnoDemo
 * @since 2023/5/25 18:11
 */
public class MyAnnoDemo {
    public static void main(String[] args) throws Exception {
        MyAnnoDemo demo = new MyAnnoDemo();
        Class<? extends MyAnnoDemo> aClass = demo.getClass();
        Method myAnno = aClass.getDeclaredMethod("myAnno");
        if (myAnno.isAnnotationPresent(MyAnno.class)) {
            System.out.println("process MyAnno annotation before...");
            myAnno.invoke(demo);
            System.out.println("process MyAnno annotation after...");
        }
    }

    @MyAnno
    public void myAnno() {
        System.out.println("myAnno...");
    }
}
