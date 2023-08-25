package problems;

public class Problem777 {
    public static void main(String[] args) {

    }

    /**
     * ①、当去掉X时L和R的相对位置和个数需相等
     *
     * ②、双指针遍历 start[i] 和 target[j]，分类讨论：
     *     - 如果当前字符为 L 且 i<j，那么这个 L 由于无法向右移动，返回 false；
     *     - 如果当前字符为 R 且 i>j，那么这个 R 由于无法向左移动，返回 false
     */
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        for (int i = 0, j = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'X') continue;
            while (end.charAt(j) == 'X') j++;
            if (i != j && (start.charAt(i) == 'L') != (i > j)) return false;
            j++;
        }
        return true;
    }
}
