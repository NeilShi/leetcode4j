import java.util.Stack;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    /**
     * 时间复杂度: todo
     * 空间复杂度:
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Stack<Character> resultStack = new Stack<Character>();
        boolean flag = true;
        int it = 0;
        while (flag) {
            for (int i = 0; i < strs.length; i++) {
                if (i == 0) {
                    resultStack.push(strs[i].toCharArray()[it]);
                }
                if (resultStack.get(resultStack.size() - 1) != strs[i].toCharArray()[it]) {
                    resultStack.pop();
                    flag = false;
                    break;
                }
                if (i == strs.length - 1) {
                    it++;
                }
            }
        }
        return stackToString(resultStack);
    }

    private String stackToString(Stack<Character> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        stack.stream().forEach(item -> stringBuilder.append(item));
        return stringBuilder.toString();
    }
}
