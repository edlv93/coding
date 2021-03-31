package bytedance;

/**
 * 72. 编辑距离
 * 三种可能的变化：
 * 1.A末尾增加一个字符
 * 2.B末尾增加一个字符
 * 3.A末尾替换一个字符
 * DB[i][j] = Min(1,2,3)
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int down = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    leftDown++;
                }
                dp[i][j] = Math.min(down, Math.min(left, leftDown));
            }
        }
        return dp[m][n];
    }
}
