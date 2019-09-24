/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Palindrome {
    /**
     * 时间复杂度: O(2log10(x))
     * 空间复杂度: O(2log10(x))
     */
    public boolean isPalindrome(int x) {
        char sourceArr[] = String.valueOf(x).toCharArray();
        char reverseArr[] = new char[sourceArr.length];
        int index = 0;
        for (int i = sourceArr.length - 1; i > -1; i--) {
            reverseArr[index++] = sourceArr[i];
        }
        return isEqual(sourceArr, reverseArr);
    }

    private boolean isEqual(char sourceArr[], char reverseArr[]) {
        if (sourceArr.length != reverseArr.length) {
            return false;
        }
        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i] != reverseArr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数学方法，取余翻转整数
     * 空间复杂度: O(1)
     *
     * 实现略
     */
}
