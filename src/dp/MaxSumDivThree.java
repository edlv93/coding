package dp;

/**
 * 1262. 可被三整除的最大和
 * https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
 * <p>
 * 状态0，1，2（和模3之后的值）
 */
public class MaxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[] dp = new int[3];
        for (int num : nums) {
            int a = dp[0] + num;
            int b = dp[1] + num;
            int c = dp[2] + num;
            int i = a % 3;
            int j = b % 3;
            int k = c % 3;
            dp[i] = Math.max(dp[i], a);
            dp[j] = Math.max(dp[j], b);
            dp[k] = Math.max(dp[k], c);
        }
        return dp[0];
    }
}
