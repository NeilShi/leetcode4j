package sort;
/**
 * 快速排序 （非leetCode题）
 * 时间复杂度：NlogN
 * 空间复杂度：logN
 * */
public class QuickSort {
    public void quickSort(int[] nums, int left, int right) {
        if (left > right || nums.length < 2) {
            return;
        }
        int mid = move(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    private int move(int[] nums, int left, int right) {
        int base = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= base) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            while (left < right && nums[left] <= base) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return left;
    }
}
