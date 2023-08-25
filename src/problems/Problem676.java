package problems;

/**
 * 676. 实现一个魔法字典
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 * <p>
 * link: https://leetcode.cn/problems/implement-magic-dictionary/
 */
public class Problem676 {
    public static void main(String[] args) {

    }

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * <pre>{@code
     *     MagicDictionary obj = new MagicDictionary();
     *     obj.buildDict(dictionary);
     *     boolean param_2 = obj.search(searchWord);
     * }</pre>
     */
    static class MagicDictionary {
        String[] dictionary;

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            this.dictionary = dictionary;
        }

        public boolean search(String searchWord) {
            for (String word : dictionary) {
                if (word.length() != searchWord.length()) continue;
                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (searchWord.charAt(i) != word.charAt(i)) {
                        if (++diff > 1) break;
                    }
                }
                if (diff == 1) return true;
            }
            return false;
        }
    }
}
