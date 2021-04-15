package everyday;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int len = r - l;
            if (len == 1) {
                return Math.min(nums[l], nums[r]);
            }
            int mid = l + (len) / 2;
            if (nums[l] < nums[mid] && nums[r] < nums[mid]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(new FindMin().findMin(new int[]{2,2,2,1,2}));
    }
}
