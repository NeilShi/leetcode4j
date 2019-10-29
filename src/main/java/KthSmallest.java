/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 * <p>
 * 示例:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (k > countLessOrEqual(matrix, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countLessOrEqual(int[][] matrix, int mid) {
        int count = 0;
        int row = matrix.length - 1;
        int col = 0;
        // 从左下角, 倒着往上找
        while (row >= 0 && col < matrix.length) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                row = matrix.length - 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
