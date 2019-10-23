package sort;
/**
 * 归并排序 （非leetCode题）
 * 时间复杂度：O(NlogN)  叶子节点为N，总结点数近似2N，递归深度log2N
 * 空间复杂度：O(N) （临时数组长度为N，大于压栈的logN）
 * */
public class MergeSort {
    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >>> 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int[] newNums = new int[end - start + 1];
        int index = 0;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                newNums[index++] = nums[left++];
            } else {
                newNums[index++] = nums[right++];
            }
        }
        while (left <= mid) {
            newNums[index++] = nums[left++];
        }
        while (right <= end) {
            newNums[index++] = nums[right++];
        }
        for (int i = 0; i < newNums.length; i++) {
            nums[start + i] = newNums[i];
        }
    }
}
