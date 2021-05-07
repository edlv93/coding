package dp;

/**
 * 91. 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && s.substring(i - 2, i).compareTo("26") <= 0) {
                dp[i] += dp[i - 2];
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("06"));
    }
}
