package javaguide.ds.designpattern.singleton;

import java.io.Serializable;

/**
 * 双检查锁 单例模式
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName Singleton
 * @since 2023/4/16 23:38
 */
// 如果实现了序列化接口, 还要做什么来防止反序列化破坏单例
public class Singleton implements Serializable {
    /**
     * 单例对象，使用 volatile 保证 可见性 以及防止 指令重排
     */
    private static volatile Singleton instance;


    private Singleton() {}

    public static Singleton getInstance() {
        // 实例没创建，才会进入内部的 synchronized代码块
        if (instance == null) {
            synchronized (Singleton.class) {
                // 也许有其它线程已经创建实例，所以再判断一次
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 重写 readResolve 防止反序列化破坏单例
    public Object readResolve() {
        return instance;
    }

    public void method() {}
}
