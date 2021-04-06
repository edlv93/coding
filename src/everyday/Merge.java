package everyday;

/**
 * 88. 合并两个有序数组
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i;
        for (i = m + n - 1, m--, n--; m >= 0 && n >= 0; i--) {
            nums1[i] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[i--] = nums2[n--];
        }
//        System.out.println(1);
    }

    public static void main(String[] args) {
        new Merge().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
