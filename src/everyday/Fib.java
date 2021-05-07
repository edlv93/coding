package everyday;

public class Fib {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = cur;
            cur = (pre + cur) % ((int) 1e9 + 7);
            pre = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Fib().fib(95));
    }
}
