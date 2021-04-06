package everyday;

/**
 * 80. 删除有序数组中的重复项 II
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 1;
        boolean flag = false;
        int target = nums[0];
        for (int i = 1; i < n; i++) {
            int now = nums[i];
            if (now == target) {
                if (!flag) {
                    nums[l++] = now;
                    flag = true;
                }
            } else {
                target    = now;
                nums[l++] = now;
                flag      = false;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
    }
}
