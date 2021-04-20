package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 87. 扰乱字符串
 * https://leetcode-cn.com/problems/scramble-string/
 * <p>
 * dp[i][j][n] s1从i开始长度为n的子串，s2从j开始长度为n的子串
 */
public class IsScramble {
    String s1, s2;
    int[][][] dp;
    // 记忆化搜索存储状态的数组
    // -1 表示 false，1 表示 true，0 表示未计算

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        this.dp = new int[n][n][n + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, n);
    }

    // 第一个字符串从 i 开始，第二个字符串从 j 开始，子串的长度为 n，是否和谐(满足扰乱条件)
    public boolean dfs(int i, int j, int n) {
        //访问过
        if (dp[i][j][n] != 0) {
            return dp[i][j][n] == 1;
        }

        // 判断两个子串是否相等
        if (s1.substring(i, i + n).equals(s2.substring(j, j + n))) {
            dp[i][j][n] = 1;
            return true;
        }

        // 判断是否存在字符 c 在两个子串中出现的次数不同
        if (!checkIfSimilar(i, j, n)) {
            dp[i][j][n] = -1;
            return false;
        }

        // 枚举分割位置
        for (int k = 1; k < n; k++) {

            // 不交换的情况
            if (dfs(i, j, k) && dfs(i + k, j + k, n - k)) {
                dp[i][j][n] = 1;
                return true;
            }
            // 交换的情况
            if (dfs(i, j + n - k, k) && dfs(i + k, j, n - k)) {
                dp[i][j][n] = 1;
                return true;
            }
        }
        dp[i][j][n] = -1;
        return false;
    }

    public boolean checkIfSimilar(int i, int j, int n) {
        Map<Character, Integer> keys = new HashMap<>();
        for (int k = i; k < i + n; k++) {
            char c = s1.charAt(k);
            keys.put(c, keys.getOrDefault(c, 0) + 1);
        }
        for (int k = j; k < j + n; k++) {
            char c = s2.charAt(k);
            keys.put(c, keys.getOrDefault(c, 0) - 1);
        }
        for (int value : keys.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

}
