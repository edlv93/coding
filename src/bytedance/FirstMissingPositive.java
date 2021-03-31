package bytedance;

/**
 * 41. 缺失的第一个正数
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    break;
                }
                int temp = nums[i];
                nums[i]        = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        new FirstMissingPositive().firstMissingPositive(new int[]{1, 1});
    }
}
