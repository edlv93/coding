package everyday;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 1562. 查找大小为 M 的最新分组
 * <p>
 * https://leetcode-cn.com/problems/find-latest-group-of-size-m/
 */
public class FindLatestStep {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        char[] s = new char[n];
        Arrays.fill(s, '0');
        int ans = -1;
        System.out.println(s);
        for (int i = 0; i < n; i++) {
            s[arr[i] - 1] = '1';
            String tmp = new String(s);
            String[] keys = tmp.substring(tmp.indexOf("1"), tmp.lastIndexOf("1") + 1).split("0");
            Arrays.sort(keys, Comparator.comparingInt(String::length));
            int l = 0, r = keys.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int len = keys[mid].length();
                if (len == m) {
                    ans = i + 1;
                    break;
                } else if (m > len) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(s);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindLatestStep().findLatestStep(new int[]{3, 5, 1, 2, 4}, 2));
    }
}
