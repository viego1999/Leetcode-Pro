package javaguide.concurrent.threadlocal;

public class ThreadLocalDemo {
    ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        Thread t1 = new Thread(() -> {
            demo.setLocalValue();
            System.out.println("t1 thread local is: " + demo.local.get());
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> System.out.println("t2 thread local is: " + demo.local.get()), "t2");
        t2.start();

        demo.setLocalValue();
        System.out.println("main thread local is:" + demo.local.get());
    }

    public void setLocalValue() {
        System.out.println(Thread.currentThread().getName() + " thread set local value...");
        local.set(Thread.currentThread().getName());
    }
}
