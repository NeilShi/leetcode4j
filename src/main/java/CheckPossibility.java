/**
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * <p>
 * 示例 1:
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * <p>
 * 示例 2:
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */
public class CheckPossibility {
    /**
     * i = 0 时，只能讲当前的换成后一个
     * others: 一共两种选择
     *  1. 把当前的换成前一个
     *  2. 把后面的换成当前的，当前的不变
     * */
    public boolean checkPossibility(int[] nums) {  // [3, 4, 2, 3]
        if (nums.length <= 2) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                count++;
                if (i == 0) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i] = nums[i - 1];   // 把当前的换成前一个
                }
                if (nums[i] > nums[i + 1]) { // 若还是比后面大，那就恢复当前，把后面换成当前
                    nums[i] = temp;
                    nums[i + 1] = nums[i];
                }
            }
        }
        return count <= 1;
    }
}
