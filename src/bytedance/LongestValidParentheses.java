package bytedance;

import java.util.Stack;

/**
 * 32. 最长有效括号
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.empty()) {
                    ans = Math.max(ans, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new LongestValidParentheses().longestValidParentheses(")()())");
    }
}
