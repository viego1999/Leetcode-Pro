package javaguide.ds.bst;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName BSTTest
 * @since 2023/3/27 0:31
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        int[] nums = {5, 3, 9, 7, 0, 1, 2, 4};

        for (int num : nums) bst.add(num);

        System.out.println("search: " + bst.search(8));
        System.out.println("search: " + bst.search(3));
        System.out.println("search: " + bst.search(4));

        System.out.println("delete: " + bst.delete(4));

        System.out.println("search: " + bst.search(4));
    }
}
