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
}
