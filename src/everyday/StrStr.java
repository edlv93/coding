package everyday;

/**
 * 28. 实现 strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * KMP算法https://zhuanlan.zhihu.com/p/83334559
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int M = needle.length();
        if (M == 0) {
            return 0;
        }
        int N = haystack.length();
        int[][] dp = generateKMP(needle);
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][haystack.charAt(i)];
            // 到达终止态，返回结果
            if (j == M) {
                return i - M + 1;
            }
        }
        // 没到达终止态，匹配失败
        return -1;
    }

    private int[][] generateKMP(String pat) {
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        int[][] dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 构建状态转移图（稍改的更紧凑了）
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[X][c];
            }
            dp[j][pat.charAt(j)] = j + 1;
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
        return dp;
    }
}
