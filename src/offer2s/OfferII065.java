package offer2s;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII065
 * @since 2023/5/13 16:38
 */
public class OfferII065 {
    public static void main(String[] args) {

    }

    public int minimumLengthEncoding_(String[] words) {
        int ans = 0;
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        for (String word : set) ans += word.length() + 1;
        return ans;
    }

    Node root = new Node();
    int ans = 0;

    public int minimumLengthEncoding(String[] words) {
        for (String word : words) {
            insert(word);
        }
        dfs(root, 0);
        return ans;
    }

    private void insert(String word) {
        char[] cs = word.toCharArray();
        int n = cs.length;
        Node p = root;
        for (int i = n - 1; i >= 0; i--) {
            if (p.childrens[cs[i] - 'a'] == null) {
                p.childrens[cs[i]- 'a'] = new Node();
            }
            p = p.childrens[cs[i] - 'a'];
        }
        p.isWord = true;
    }

    public void dfs(Node node, int prev) {
        if (node == null) return;
        int cnt = 0;
        for (Node children : node.childrens) {
            if (children != null) {
                dfs(children, prev + 1);
                cnt++;
            }
        }
        if (cnt == 0) ans += prev + 1;
    }

    static class Node {
        Node[] childrens = new Node[26];
        boolean isWord;
    }
}
