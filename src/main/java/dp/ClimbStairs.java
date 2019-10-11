package dp;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs {
    int count = 0;
    int dpCount = 0;

    public int climbStairsMemo(int n) {
        // 记忆化递归层数
        dpCount++;

        int[] memo = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }
        if (n == 1) {
            return memo[1] = 1;
        } else if (n == 2) {
            return memo[2] = 2;
        } else if (memo[n] > 0) {
            return memo[n];
        } else {
            return memo[n] = climbStairsMemo(n - 1) + climbStairsMemo(n - 2);
        }
    }

    public int climbStairs(int n) {
        // 递归层数
        count++;

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }


}
