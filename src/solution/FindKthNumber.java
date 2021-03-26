package solution;

/**
 * 440. 字典序的第K小数字
 */
public class FindKthNumber {
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        k = k - 1;
        while (k > 0) {
            int count = getCount(prefix, n);
            if (count > k) { //在当前prefix的数下
                prefix *= 10;
                k -= 1;
            } else {
                prefix++;
                k -= count;
            }
        }
        return prefix;
    }

    public int getCount(int prefix, int n) {
        int cur = prefix;
        int next = prefix + 1;
        int count = 0;
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        new FindKthNumber().findKthNumber(20, 3);
    }
}
