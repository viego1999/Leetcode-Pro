package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1401
 * @since 2023/6/25 14:02
 */
public class Problem1401 {
    public static void main(String[] args) {

    }

    // https://blog.csdn.net/qq_41685265/article/details/107674368
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double minx = Math.min(Math.abs(xCenter - x1), Math.abs(xCenter - x2));
        double miny = Math.min(Math.abs(yCenter - y1), Math.abs(yCenter - y2));
        double x0 = (x1 + x2) / 2., y0 = (y1 + y2) / 2.;
        if (minx * minx + miny * miny <= radius * radius) return true;
        return (Math.abs(xCenter - x0) <= Math.abs(x1 - x2) / 2. + radius && Math.abs(yCenter - y0) <= Math.abs(y1 - y2) / 2.) ||
                (Math.abs(xCenter - x0) <= Math.abs(x1 - x2) / 2. && Math.abs(yCenter - y0) <= Math.abs(y1 - y2) / 2. + radius);
    }
}
