package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII062
 * @since 2023/5/11 15:04
 */
public class OfferII062 {
    public static void main(String[] args) {

    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    static class Trie {
        Node root = new Node();

        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] cs = word.toCharArray();
            Node p = root;
            for (char c : cs) {
                if (p.childrens[c - 'a'] == null) {
                    p.childrens[c - 'a'] = new Node();
                }
                p = p.childrens[c - 'a'];
            }
            p.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] cs = word.toCharArray();
            Node p = root;
            for (char c : cs) {
                if (p.childrens[c - 'a'] == null) return false;
                p = p.childrens[c - 'a'];
            }
            return p != null && p.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] cs = prefix.toCharArray();
            Node p = root;
            for (char c : cs) {
                if (p.childrens[c - 'a'] == null) return false;
                p = p.childrens[c - 'a'];
            }
            return true;
        }

        static class Node {
            boolean isWord;
            Node[] childrens = new Node[26];
        }
    }
}
