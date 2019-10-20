package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * */
public class Subsets {
    /**
     * 回溯法
     * 时间复杂度：O(2^N)
     * 空间复杂度：O(N)
     * */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void backTrack(int i, int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        ans.add(new ArrayList<>(temp)); // copy
        // find next
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            backTrack(j + 1, nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
