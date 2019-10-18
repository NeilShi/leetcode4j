package dp;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * */
public class LengthOfLIS {
    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     * */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        // 此处的stream操作改用for循环，能节省2/3左右的时间
        dp = Arrays.stream(dp).map(x -> 1).toArray();
        int maxVal = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = dp[i] > (dp[j] + 1) ? dp[i] : (dp[j] + 1);
                    maxVal = maxVal > dp[i] ? maxVal : dp[i];
                }
            }
        }
        return maxVal;
    }
}
