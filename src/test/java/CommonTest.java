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
}
