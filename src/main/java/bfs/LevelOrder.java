package bfs;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * */
public class LevelOrder {
    private List<List<Integer>> ans = new ArrayList<>();
    /**
     * 递归
     * */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return ans;
        }
        bfs(root, 0);
        return ans;
    }

    private void bfs(TreeNode root, int level) {
        if (ans.size() <= level) {
            ans.add(level, new ArrayList<>());
        }
        ans.get(level).add(root.val);
        if (root.left != null) {
            bfs(root.left, level + 1);
        }
        if (root.right != null) {
            bfs(root.right, level + 1);
        }
    }

    /**
     * 用队列实现bfs
     * */
//    public List<List<Integer>> levelOrder2(TreeNode root) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.remove();
//            if (node.left != null) {
//                queue.add(node.left);
//            }
//            if (node.right != null) {
//                queue.add(node.right);
//            }
//        }
//    }
}
