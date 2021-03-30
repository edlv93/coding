package common;

public class QuickSort {
    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int index = getIndex(nums, l, r);
            quickSort(nums, l, index - 1);
            quickSort(nums, index + 1, r);
            System.out.println(1);
        }
    }

    static int getIndex(int[] nums, int l, int r) {
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
        QuickSort.quickSort(new int[]{3, 2, 1, 5, 6, 4}, 0, 5 );
    }
}
