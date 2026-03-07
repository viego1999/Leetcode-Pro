package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem394
 * @since 2026/3/1 21:19
 */
public class Problem394 {
    //示例 2：
    //
    //输入：s = "3[a2[c]]1[b]"
    //输出："accaccaccb"
    //
    // 1[a2[3[b]1[b]]
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for (int i = 0, num = 0; i < cs.length; i++) {
            if (Character.isDigit(cs[i])) num = num * 10 + (cs[i] - '0');
            else if (cs[i] == '[') {
                nums.push(num);
                num = 0;
                stack.push(sb.toString());
                sb.delete(0, sb.length());
            } else if (cs[i] == ']') {
                int cnt = nums.pop();
                String ss = sb.toString();
                for (int j = 1; j < cnt; j++) sb.append(ss);
                sb.insert(0, stack.pop());
            } else sb.append(cs[i]);
        }
        return sb.toString();
    }
}
