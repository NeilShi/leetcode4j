import datastructure.ListNode;
import datastructure.TreeNode;
import dfs.MaxDepth;
import dp.ClimbStairs;
import dp.MaxSubArray;
import greedy.MaxProfit;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class CommonTest {
    @Test
    public void testTowSum1() {
        int nums[] = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        Assert.assertArrayEquals(twoSum.twoSum1(nums, target), new int[]{0, 1});
    }

    @Test
    public void testTowSum2() {
        int nums[] = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        Assert.assertArrayEquals(twoSum.twoSum2(nums, target), new int[]{0, 1});
    }

    @Test
    public void testReverse() {
        int x = 0;
        Reverse reverse = new Reverse();
        Assert.assertEquals(reverse.reverse(x), 0);
    }

    @Test
    public void testValidKH() {
        String s = "()[]";
        ValidKH validKH = new ValidKH();
        Assert.assertTrue(validKH.isValid(s));
    }

    @Test
    public void testMergeList() {
        /**
         * 1->3->5, 2->4->6
         * */
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(6);
        l21.next = l22;
        l22.next = l23;

        MergeList ml = new MergeList();
        ml.mergeTwoLists3(l11, l21);
    }

    @Test
    public void testPalindrome() {
        int x = 121;
        Palindrome palindrome = new Palindrome();
        Assert.assertTrue(palindrome.isPalindrome(x));
    }

    @Test
    public void testLongestCommonPrefix() {
        String strs1[] = {};
        String strs2[] = {""};
        String strs3[] = {"a"};
        String strs4[] = {"abbb", "accc", "addd"};
        String strs5[] = {"flower", "flow", "flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        longestCommonPrefix.longestCommonPrefix(strs4);
    }

    @Test
    public void testSameTree() {
        // one pass no test
        SameTree sameTree = new SameTree();
        Assert.assertTrue(sameTree.isSameTree(null, null));
    }

    @Test
    public void testMaxSubArray() {
        MaxSubArray maxSubArray = new MaxSubArray();
//        maxSubArray.maxSubArray(new int[]{-2,-3,-5});
        maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    @Test
    public void testClimbStairs() {
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.climbStairsDp(10);
    }

    @Test
    public void testMaxProfit() {
        // one pass no test
        MaxProfit maxProfit = new MaxProfit();
        maxProfit.maxProfit(new int[]{0});
    }

    @Test
    public void testMaxDepth() {
        MaxDepth maxDepth = new MaxDepth();
        LinkedList<Integer> arr = new LinkedList<>(Arrays.asList(0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8));
        arr.addFirst(-1);
        TreeNode root = constructBinaryTree(arr, 1);
        maxDepth.maxDepthBfs(root);
    }

    private TreeNode constructBinaryTree(LinkedList<Integer> arr, int index) {
        if (index < arr.size()) {
            Integer value = arr.get(index);
            if (value != null) {
                TreeNode t = new TreeNode(value);
                t.left = constructBinaryTree(arr, index * 2);
                t.right = constructBinaryTree(arr, index * 2 + 1);
                return t;
            }
        }
        return null;
    }
}
