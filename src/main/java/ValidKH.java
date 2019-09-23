import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidKH {
    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char charArr[] = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (!stack.empty() && match(stack.peek(), charArr[i])) {
                stack.pop();
                continue;
            }
            stack.push(charArr[i]);
        }
        return stack.empty();
    }

    private boolean match(char source, char target) {
        if (source == '(' && target == ')') {
            return true;
        }
        if (source == '{' && target == '}') {
            return true;
        }
        if (source == '[' && target == ']') {
            return true;
        }
        return false;
    }
}
