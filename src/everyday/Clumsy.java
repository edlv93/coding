package everyday;

import java.util.Stack;

/**
 * 1006. 笨阶乘
 */
public class Clumsy {
    public int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        int sign = 1;
        for (int i = N - 1; i >= 1; i--) {
            switch (sign) {
                case 1: {
                    stack.push(stack.pop() * i);
                    break;
                }
                case 2: {
                    stack.push(stack.pop() / i);
                    break;
                }
                case 3: {
                    stack.push(i);
                    break;
                }
                case 4: {
                    stack.push(-i);
                    break;
                }
            }
            sign++;
            if (sign == 5) {
                sign = 1;
            }
        }
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        new Clumsy().clumsy(10);
    }
}
