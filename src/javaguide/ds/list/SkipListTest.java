package javaguide.ds.list;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName SkipListTest
 * @since 2023/4/8 19:07
 */
public class SkipListTest {
    public static void main(String[] args) {
        List<Integer> skipList = new SkipList<>();

        System.out.println("add 3: " + skipList.add(3));
        System.out.println("add 4: " + skipList.add(4));
        System.out.println("add 6: " + skipList.add(6));
        System.out.println("add 4: " + skipList.add(4));

        System.out.println("search 8: " + skipList.search(8));
        System.out.println("search 6: " + skipList.search(6));

        System.out.println("delete 6: " + skipList.delete(6));
        System.out.println("search 6: " + skipList.search(6));

        System.out.println("size: " + skipList.size());
    }
}
