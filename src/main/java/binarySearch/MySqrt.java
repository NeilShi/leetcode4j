package binarySearch;
/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 * */
public class MySqrt {
    /**
     * 时间复杂度：O(logN)  二分查找的时间复杂度为对数级别
     * 空间复杂度: O(1)
     * */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long left = 1;
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            if (mid*mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}
