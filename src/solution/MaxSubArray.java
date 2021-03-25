package solution;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < n; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static void main(String[] args) {
        new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
