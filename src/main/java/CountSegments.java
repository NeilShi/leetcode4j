/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * <p>
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class CountSegments {
    public int countSegments(String s) {
        int ans = 0;
        s = s.trim();   // 去掉头尾空格
        if (s.length() == 0) {
            return ans;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ans++;
            }
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
        }
        return ans + 1;
    }
}
