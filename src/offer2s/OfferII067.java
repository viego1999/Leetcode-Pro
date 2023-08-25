package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII067
 * @since 2023/5/14 22:21
 */
public class OfferII067 {
    public static void main(String[] args) {

    }

    Node root = new Node();

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            add(i);
            int j = getX(i);
            ans = Math.max(ans, i ^ j);
        }
        return ans;
    }

    public void add(int num) {
        Node p = root;
        for (int i = 31; i >= 0; i--) {
            int c = (num >> i) & 1;
            if (p.childrens[c] == null) p.childrens[c] = new Node();
            p = p.childrens[c];
        }
    }

    public int getX(int num) { // 返回当前数中尽量与num异或大的数
        Node p = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int a = (num >> i) & 1, b = 1 ^ a;
            if (p.childrens[b] != null) {
                ans |= (b << i);
                p = p.childrens[b];
            } else {
                ans |= (a << i);
                p = p.childrens[a];
            }
        }
        return ans;
    }

    static class Node {
        Node[] childrens = new Node[2];
    }
}
