package bytedance;

/**
 * 221. 最大正方形
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int value = Math.min(dp[i][j - 1], dp[i - 1][j - 1]);
                    value = Math.min(value, dp[i - 1][j]);
                    value++;
                    dp[i][j] = value;
                    max = Math.max(max, value);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
}
