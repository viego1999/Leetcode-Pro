package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1032
 * @since 2023/3/24 13:27
 */
public class Problem1032 {
    public static void main(String[] args) {
        StreamChecker sc = new StreamChecker(new String[]{"", ""});
        System.out.println(sc.query('a'));
    }

    /**
     * Your StreamChecker object will be instantiated and called as such:
     * <pre>{@code
     *    StreamChecker obj = new StreamChecker(words);
     *    boolean param_1 = obj.query(letter);
     * } </pre>
     */
    static class StreamChecker {
        Node root = new Node();
        StringBuilder sb = new StringBuilder();

        public StreamChecker(String[] words) {
            for (String word : words) {
                Node p = root;
                char[] cs = word.toCharArray();
                for (int i = cs.length - 1; i >= 0; i--) {
                    if (p.children[cs[i] - 'a'] == null) {
                        p.children[cs[i] - 'a'] = new Node();
                    }
                    p = p.children[cs[i] - 'a'];
                }
                p.isWord = true;
            }
        }

        public boolean query(char c) {
            sb.append(c);
            Node p = root;
            for (int i = sb.length() - 1; i >= 0 && p != null; i--) {
                p = p.children[sb.charAt(i) - 'a'];
                if (p != null && p.isWord) return true;
            }
            return false;
        }

        private static class Node {
            boolean isWord;
            Node[] children = new Node[26];
        }
    }
}
