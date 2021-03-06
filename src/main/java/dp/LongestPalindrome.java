package dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    /**
     * DP优化暴力法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * */
    public String longestPalindromeDp(String s) {
        String ans = "";
        if (s.length() == 0) {
            return ans;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 由长度从小到大进行遍历，这样dp[start + 1][end - 1]长度较小一定会先算出来
        for (int len = 1; len <= s.length(); len ++) {
            for (int start = 0; start < s.length(); start++) {
                int end = start + len - 1;
                if (end >= s.length()) {
                    break;
                }
                dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (dp[start][end]) {
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }

    /**
     * time out !
     * 暴力法
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(n)
     * */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] chArr = s.toCharArray();
        int maxLen = 0;
        HashMap<Integer, String> ans = new HashMap<>();
        for (int i = 0; i < chArr.length; i++) {
            for (int j = i; j < chArr.length; j++) {
                char[] subChArr = Arrays.copyOfRange(chArr, i, j + 1);
                if (isPalindrome(subChArr)) {
                    ans.put(j - i + 1, String.valueOf(subChArr));
                    maxLen = maxLen > j - i + 1 ? maxLen : j - i + 1;
                }
            }
        }

        return ans.get(maxLen);
    }

    public boolean isPalindrome(char[] chars) {
        int len = chars.length;
        if (len == 1) return true;
        if (len == 2) return chars[0] == chars[1];
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            if (chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
