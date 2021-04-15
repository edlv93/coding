package competition.w0411;

import java.util.Arrays;

/**
 * 1824. 最少侧跳次数
 *
 * https://leetcode-cn.com/problems/minimum-sideway-jumps/
 */
public class MinSideJumps {

    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[4];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        int n = obstacles.length;
        for (int i = 1; i < n - 1; i++) {
            int[] pre = new int[4];
            for (int j = 1; j < 4; j++) {
                pre[j] = dp[j];
            }
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            for (int j = 1; j < 4; j++) {
                if (obstacles[i] != j) {
                    dp[j] = pre[j];
                }
            }
            for (int j = 1; j < 4; j++) {
                if (obstacles[i] != j) {
                    for (int k = 1; k < 4; k++) {
                        if (k != j) {
                            dp[j] = Math.min(dp[j], dp[k] + 1);
                        }
                    }
                }
            }
            System.out.println(1);
        }
        return Math.min(dp[1], Math.min(dp[2], dp[3]));
    }

    public static void main(String[] args) {
        System.out.println(
                new MinSideJumps().minSideJumps(new int[]{0,0,2,0,0,0,2,1,2,0,0}));
    }
}
