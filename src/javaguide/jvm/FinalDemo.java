package javaguide.jvm;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName FinalDemo
 * @since 2023/2/11 14:57
 */
public class FinalDemo {

    public static void main(String[] args) throws Exception {
        OutClass outClass = new OutClass();
        Object inClass = outClass.outPrint(12);
        System.out.println(inClass);
    }

    // final作为形参，只能读，不能写
    public void testFinalParam(final Object o) {
        System.out.println(o);
    }

    public void testFinalLocalVar() {
        // 可以先声明
        final Object o;
        // 后赋值（只能赋值一次）
        o = new Object();
        System.out.println(o);
    }

    /**
     * Outer class
     */
    static class OutClass {
        private int x = 12;

        /**
         * outer class print method
         *
         * @param y param y
         * @return InClass instance
         */
        public Object outPrint(int y) {
            /**
             * Inner class
             */
            class InClass {
                /**
                 * inner class print method
                 */
                public void inPrint() {
                    System.out.println("x = " + x);
                    System.out.println("y = " + y);
                }
            }
            InClass inClass = new InClass();
            inClass.inPrint();
            return inClass;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}
