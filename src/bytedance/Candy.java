package bytedance;

/**
 * 135. 分发糖果
 */
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0 && ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int ans = 0;
        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i <= n - 2 && ratings[i + 1] < ratings[i]) {
                right++;
            } else {
                right = 1;
            }
            ans += Math.max(left[i], right);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Candy().candy(new int[]{1,0,2});
    }
}
