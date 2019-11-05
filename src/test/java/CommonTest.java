import backtrack.Subsets;
import bfs.LevelOrder;
import binarySearch.BinarySearch;
import binarySearch.FindKthNumber;
import binarySearch.MySqrt;
import com.sun.org.apache.bcel.internal.generic.LADD;
import datastructure.ListNode;
import datastructure.TreeNode;
import bfs.IsSymmetric;
import dfs.MaxDepth;
import dfs.NumIslands;
import dp.*;
import greedy.MaxProfit;
import greedy.MaxProfit2;
import greedy.RemoveDuplicateLetters;
import org.junit.Assert;
import org.junit.Test;
import sort.MergeSort;
import sort.QuickSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    @Test
    public void testIsSymmetric() {
        IsSymmetric isSymmetric = new IsSymmetric();
        LinkedList<Integer> arr = new LinkedList<>(Arrays.asList(9, -42, -42, null, 76, 76, null, null, 13, null, 13));
        arr.addFirst(-1);
        TreeNode root = constructBinaryTree(arr, 1);
        isSymmetric.isSymmetric(root);
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

    @Test
    public void testLongestPalindrome() {
        LongestPalindrome lp = new LongestPalindrome();
        String ans = lp.longestPalindromeDp("abcsasd");
        Assert.assertEquals("sas", ans);
    }

    @Test
    public void testMySqrt() {
        MySqrt mySqrt = new MySqrt();
        Assert.assertEquals(1, mySqrt.mySqrt(3));
    }

    @Test
    public void testBinarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        Assert.assertEquals(binarySearch.search(nums, target), 4);
    }

    @Test
    public void testLenghOfLIS() {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
        Assert.assertEquals(6, lengthOfLIS.lengthOfLIS(nums));
    }

    @Test
    public void testInOrderTraversal() {
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(1,null,2,null,null,3));
        input.addFirst(-1);
        TreeNode root = constructBinaryTree(input, 1);
        inOrderTraversal.inorderTraversal(root);
    }

    @Test
    public void testSubsets() {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[]{1, 2, 3});
    }

    @Test
    public void testQuickSort() {
        int[] nums = new int[]{8, 3, 1, 9, 25, 4, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        Assert.assertTrue(nums.length > 0);
    }

    @Test
    public void testMergeSort() {
        int[] nums = new int[]{8, 3, 1, 9, 25, 4, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1);
        Assert.assertTrue(nums.length > 0);
    }

    @Test
    public void testConsecutiveNumbersSum() {
        ConsecutiveNumbersSum consecutiveNumbersSum = new ConsecutiveNumbersSum();
        Assert.assertEquals(2, consecutiveNumbersSum.consecutiveNumbersSum(5));
    }

    @Test
    public void testFindKthNumber() {
        FindKthNumber findKthNumber = new FindKthNumber();
        findKthNumber.findKthNumber(3, 3, 5);
    }

    @Test
    public void testLargestBSTSubtree() {
        LargestBSTSubtree largestBSTSubtree = new LargestBSTSubtree();
        LinkedList<Integer> tree = new LinkedList<>(Arrays.asList(10,5,15,1,8,null,7));
        tree.addFirst(-1);
        TreeNode root = constructBinaryTree(tree, 1);
        largestBSTSubtree.largestBSTSubtree(root);
    }

    @Test
    public void testRemoveDuplicateLetters() {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        removeDuplicateLetters.removeDuplicateLetters("cbacdcbc");
    }

    @Test
    public void testMinDistance() {
        MinDistance minDistance = new MinDistance();
        Assert.assertEquals(minDistance.minDistance("horse", "ros"), 3);
    }

    @Test
    public void testCountSegments() {
        CountSegments countSegments = new CountSegments();
        Assert.assertEquals(5, countSegments.countSegments(" Hello, my name is John "));
    }

    @Test
    public void testMinIncrementForUnique() {
        MinIncrementForUnique minIncrementForUnique = new MinIncrementForUnique();
        Assert.assertEquals(6, minIncrementForUnique.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }

    @Test
    public void testKthSmallest() {
        KthSmallest kthSmallest = new KthSmallest();
        Assert.assertEquals(13, kthSmallest.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8));
    }

    @Test
    public void testCheckPossibility() {
        CheckPossibility checkPossibility = new CheckPossibility();
        Assert.assertTrue(!checkPossibility.checkPossibility(new int[]{3, 4, 2, 3}));
    }

    @Test
    public void testSpiralOrder() {
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> except = new ArrayList<>(Arrays.asList(1,2,3,6,9,8,7,4,5));
        Assert.assertEquals(except, spiralOrder.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }

    @Test
    public void testLevelOrder() {
        LevelOrder levelOrder = new LevelOrder();
        Assert.assertEquals(true, true);
    }

    @Test
    public void testLevelOrderBottom() {
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        Assert.assertEquals(true, true);
    }

    @Test
    public void testNumIslands() {
        NumIslands numIslands = new NumIslands();
        Assert.assertEquals(true, true);
    }

    @Test
    public void testMerge() {
        Merge merge = new Merge();
        int[] num1 = {2, 0};
        int[] num2 = {1};
        merge.merge(num1, 1, num2, 1);
        Assert.assertEquals(true, true);
    }

    @Test
    public void testMaxProfit2() {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        Assert.assertEquals(true, true);
    }

    @Test
    public void testAddTwoNumbers() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        addTwoNumbers.addTwoNumbers(l1, l2);
    }

    @Test
    public void testLRUCache() {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
