package javaguide.ds.designpattern.adapter;

/**
 * 两项插孔接口
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName DualPin
 * @since 2023/4/23 11:24
 */
public interface DualPin {

    /**
     * 通电方法
     *
     * @param l live 火线
     * @param n null 零线
     */
    void electrify(int l, int n);

}
