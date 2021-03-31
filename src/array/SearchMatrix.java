package array;

/**
 * 74. 搜索二维矩阵
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        for (; i < m; i++) {
            if (matrix[i][n - 1] > target) {
                break;
            } else if (matrix[i][n - 1] == target) {
                return true;
            }
        }
        if (i == m) {
            return false;
        }
        int index = binarySearch(matrix[i], target);
        if (index == -1) {
            return false;
        }
        return true;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
