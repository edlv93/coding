package bytedance;

import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class IsValid {
    public boolean isValid(String s) {
        char first = s.charAt(0);
        if (first != '{' && first != '(' && first != '[') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char left = stack.pop();
                if (left == '{' && c != '}') {
                    return false;
                }
                if (left == '(' && c != ')') {
                    return false;
                }
                if (left == '[' && c != ']') {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('{' - ')');
        System.out.println('(' - ')');
        System.out.println('[' - ']');
    }
}
