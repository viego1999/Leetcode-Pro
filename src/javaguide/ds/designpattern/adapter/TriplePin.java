package javaguide.ds.designpattern.adapter;

/**
 * 三项插孔类（现有的类）
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName TriplePin
 * @since 2023/4/23 11:21
 */
public class TriplePin {

    /**
     * 通电方法
     *
     * @param l live 火线
     * @param n null 零线
     * @param e earth 地线
     */
    public void electrify(int l, int n, int e) {
        if (l >= 0) System.out.println("link: " + l);
        if (n >= 0) System.out.println("null: " + n);
        if (e >= 0) System.out.println("earth: " + e);
    }

}
