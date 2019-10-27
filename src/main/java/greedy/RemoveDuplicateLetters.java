package greedy;

import java.util.*;

/**
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.contains(ch)) {  // ??? TODO
                continue;
            }
            while (!stack.isEmpty() && s.lastIndexOf(stack.peek()) > i && ch < stack.peek()) {
                stack.pop();
            }
            stack.push(ch);
        }
        List<?> chArr = new ArrayList<>(Arrays.asList(stack.toArray()));
        Collections.reverse(chArr);
        chArr.stream().forEach(ch -> {
            ans.append(ch);
        });
        return ans.toString();
    }
}
