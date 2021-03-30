package bytedance;

/**
 * 	#215 数组中的第K个最大元素
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k-1, 0, nums.length - 1);
    }

    public int quickSelect(int[] nums, int k, int l, int r) {
        int index = getIndex(nums, l, r);
        if (index == k) {
            return nums[k];
        } else {
            return index < k
                   ? quickSelect(nums, k, index + 1, r)
                   : quickSelect(nums, k, l, index - 1);
        }
    }

    int getIndex(int[] nums, int l, int r) {
        int x = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= x) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] > x) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = x;
        return l;
    }

    public static void main(String[] args) {
//        new FindKthLargest().quickSort(new int[]{3, 2, 1, 5, 6, 4}, 0, 5);
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
