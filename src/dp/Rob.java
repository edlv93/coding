package dp;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 * 因为第一家和最后一家也是挨着的，所以分别计算从[1,n-1]和[2,n]的结果取最大值
 */
public class Rob {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robFromRange(nums, 0, n - 2), robFromRange(nums, 1, n - 1));
    }

    public int robFromRange(int[] nums, int begin, int end) {
        if(begin == end){
            return nums[begin];
        }
        int pre = nums[begin];
        int cur = Math.max(pre, nums[begin + 1]);
        for (int i = begin + 2; i <= end; i++) {
            int tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{1, 2, 3, 1}));
    }
}
