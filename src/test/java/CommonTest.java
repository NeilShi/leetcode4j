import datastructure.ListNode;
import org.junit.Assert;
import org.junit.Test;

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
         * [-10,-10,-9,-4,1,6,6]
         * [-7]
         * */
        ListNode l11 = new ListNode(-10);
        ListNode l12 = new ListNode(-10);
        ListNode l13 = new ListNode(-9);
        ListNode l14 = new ListNode(-4);
        ListNode l15 = new ListNode(1);
        ListNode l16 = new ListNode(6);
        ListNode l17 = new ListNode(6);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;

        ListNode l2 = new ListNode(-7);

        MergeList ml = new MergeList();
        ml.mergeTwoLists(l11, l2);
    }
}
