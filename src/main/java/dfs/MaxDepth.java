package dfs;

import datastructure.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth {
    /**
     * 自底向上的思想
     * 当前节点的深度为儿子节点的深度 + 1
     * null节点深度为0，即叶子节点的深度为1，向上递推
     * 空间复杂度：
     *      最坏情况，二叉树不平衡成链表，栈塞满再弹出，O(N)
     *      最好情况，完全平衡二叉树， O(logN)
     * 时间复杂度：O(N)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        return Math.max(leftH, rightH) + 1;
    }

    /**
     * DFS
     * 用栈实现
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public int maxDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.push(new Pair<>(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int currentDepth = pair.getValue();
            if (node != null) {
                depth = Math.max(depth, currentDepth);
                stack.push(new Pair<>(node.right, currentDepth + 1));
                stack.push(new Pair<>(node.left, currentDepth + 1));
            }
        }
        return depth;
    }
}
