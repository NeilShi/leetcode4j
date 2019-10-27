package binarySearch;
/**
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 例 1：
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 *
 * 例 2：
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 *
 * 注意：
 * m 和 n 的范围在 [1, 30000] 之间。
 * k 的范围在 [1, m * n] 之间。
 * */
public class FindKthNumber {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m*n;
        while (left < right) {
            int mid = (left + right)>>>1; // mid 是值 不是下标
            if (k > countLess(mid, m, n)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 计算小于等于mid的个数, 可以画乘法表验证
    private int countLess(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i<=m; i++) {
            // mid除以行号i, 如果是当前行, 则恰好为列号
            if(mid/i > n) {
                count += n;  // 在当前行上一行, 直接加上列数
            } else {
                count += mid/i; // 在当前行或者下面行, 整除的值恰好是<=mid的数量
            }
        }
        return count;
    }
}
