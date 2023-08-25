package problems;

public class Problem676_ {
    public static void main(String[] args) {

    }

    static class MagicDictionary {
        Trie root;

        public MagicDictionary() {
            root = new Trie();
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                Trie p = root;
                for (char c : word.toCharArray()) {
                    int idx = c - 'a';
                    if (p.children[idx] == null) {
                        p.children[idx] = new Trie();
                    }
                    p = p.children[idx];
                }
                p.isWord = true;
            }
        }

        public boolean search(String searchWord) {
            return dfs(searchWord.toCharArray(), root, 0, false);
        }

        public boolean dfs(char[] chars, Trie trie, int t, boolean modify) {
            if (t == chars.length) return modify && trie.isWord;
            int idx = chars[t] - 'a';
            if (trie.children[idx] != null) {
                if (dfs(chars, trie.children[idx], t + 1, modify)) return true;
            }
            if (!modify) {
                for (Trie node : trie.children) {
                    if (node != trie.children[idx] &&
                            node != null &&
                            dfs(chars, node, t + 1, true)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    static class Trie {
        boolean isWord;
        Trie[] children;

        public Trie() {
            children = new Trie[26];
        }
    }
}
