package dp;

import java.util.Arrays;

/**
 * 1691. 堆叠长方体的最大高度
 */
public class MaxHeight {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int[] nums : cuboids) {
            Arrays.sort(nums);
        }
        Arrays.sort(cuboids,
                    (o1, o2) -> o1[0] == o2[0] ? (o1[1] == o2[1] ? o1[2] - o2[2] : o1[1] - o2[1])
                                               : o1[0] - o2[0]);
        int ans;
        int[] dp = new int[n];
        ans = dp[0] = cuboids[0][2];
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (cuboids[j][1] <= cuboids[i][1]
                    && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += cuboids[i][2];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new MaxHeight().maxHeight(new int[][]{{50, 45, 20}, {95, 37, 53}, {45, 23, 12}});
    }
}
