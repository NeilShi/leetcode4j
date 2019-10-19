import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * */
public class InOrderTraversal {
    /**
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)最坏 O(logN)平衡
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursive(root, ans);
        return ans;
    }

    private void recursive(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        recursive(node.left, ans);
        ans.add(node.val);
        recursive(node.right, ans);
    }

    /**
     * other solution
     * */
}
