package everyday;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 */
public class FindMin2 {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return search(nums, 0, n - 1);
    }

    public int search(int[] nums, int l, int r) {
        while (l <= r) {
            int len = r - l;
            if (len == 1) {
                return Math.min(nums[l], nums[r]);
            }
            int mid = l + (len) / 2;
            if (nums[l] < nums[mid]) {
                if (nums[r] >= nums[mid]) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else if (nums[l] == nums[mid]) {
                if (nums[r] == nums[mid]) {
                    return Math.min(search(nums, l, mid), search(nums, mid, r));
                } else {
                    l = mid;
                }
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(new FindMin2().findMin(new int[]{10, 1, 10, 10, 10}));
    }
}
