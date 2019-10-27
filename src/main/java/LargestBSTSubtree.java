import datastructure.TreeNode;

/**
 * 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，其中最大指的是子树节点数最多的。
 * 注意:
 * 子树必须包含其所有后代。
 *
 * 示例:
 * 输入: [10,5,15,1,8,null,7]
 *
 *    10
 *    / \
 *   5  15
 *  / \   \
 * 1   8   7
 *
 * 输出: 3
 * 解释: 高亮部分为最大的 BST 子树。
 *      返回值 3 在这个样例中为子树大小。
 * 进阶:
 * 你能想出用 O(n) 的时间复杂度解决这个问题吗？
 * */
public class LargestBSTSubtree {
    private int ans = 0;
    private int preVal = Integer.MIN_VALUE;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preVal = Integer.MIN_VALUE;  // 此处重要 每次判定前初始化
        if (isBST(root)) {
            ans = Math.max(ans, getCount(root));
        }
        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);
        return ans;
    }

    // BST中序遍历为升序 拉平成数组再分析
    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftFlag = isBST(root.left);
        if (root.val <= preVal) {
            return false;
        }
        preVal = root.val;
        boolean rightFlag = isBST(root.right);
        return leftFlag && rightFlag;
    }

    private int getCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftNum = getCount(node.left);
        int rightNum = getCount(node.right);
        return leftNum + rightNum + 1;
    }
}
